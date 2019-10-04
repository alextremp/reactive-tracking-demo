package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alextremp.reactivetrackingdemo.application.SavePulsesService;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.PulseEvent;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class TrackingController {

    private final Logger LOG = Logger.getLogger(TrackingController.class.getName());
    private final ObjectMapper objectMapper;
    private final SavePulsesService savePulsesService;

    @Autowired
    public TrackingController(ObjectMapper objectMapper, SavePulsesService savePulsesService) {
        this.objectMapper = objectMapper;
        this.savePulsesService = savePulsesService;
    }

    @Cacheable("TrackingController#savePulses")
    @PostMapping
    public Mono<SavePulsesResponse> savePulses(@RequestBody String createEventsRequestString) {
        return Mono.fromCallable(() -> objectMapper.readValue(createEventsRequestString, SavePulsesRequest.class))
                .subscribeOn(Schedulers.parallel())
                .flatMap(savePulsesService::savePulses)
                .onErrorResume(throwable -> onCreateEventsError(createEventsRequestString, throwable))
                .doOnNext(response -> LOG.info("response: " + response));
    }

    private Mono<SavePulsesResponse> onCreateEventsError(String createEventsRequestString, Throwable error) {
        return Mono.fromCallable(() -> savePulsesRequestErrorsavePulsesRequestError(createEventsRequestString, error))
                .flatMap(savePulsesService::savePulses);
    }

    private SavePulsesRequest savePulsesRequestErrorsavePulsesRequestError(String receivedRequest, Throwable error) {
        SavePulsesRequest request = new SavePulsesRequest();
        request.setClientId("reactive-tracking-demo-error");
        PulseEvent pulseData = new PulseEvent();
        pulseData.setEventName("REQUEST_ERROR");
        pulseData.getPayload().put("receivedRequest", receivedRequest);
        pulseData.getPayload().put("error", error);
        request.setEvents(new PulseEvent[]{pulseData});
        return request;
    }
}
