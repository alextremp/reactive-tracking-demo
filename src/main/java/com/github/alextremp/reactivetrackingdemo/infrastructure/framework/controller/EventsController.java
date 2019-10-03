package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alextremp.reactivetrackingdemo.application.CreateEventsService;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsRequest;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsRequestError;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/")
public class EventsController {

    private final Logger LOG = Logger.getLogger(EventsController.class.getName());
    private final ObjectMapper objectMapper;
    private final CreateEventsService createEventsService;

    @Autowired
    public EventsController(ObjectMapper objectMapper, CreateEventsService createEventsService) {
        this.objectMapper = objectMapper;
        this.createEventsService = createEventsService;
    }

    @Cacheable("EventsController#createEvents")
    @PostMapping
    public Mono<CreateEventsResponse> createEvents(@RequestBody String createEventsRequestString) {
        return Mono.fromCallable(() -> objectMapper.readValue(createEventsRequestString, CreateEventsRequest.class))
                .subscribeOn(Schedulers.parallel())
                .flatMap(createEventsService::createEvents)
                .doOnNext(response -> LOG.info("response: " + response))
                .onErrorResume(throwable -> {
                    LOG.log(Level.SEVERE, "ERROR", throwable);
                    return onCreateEventsError(createEventsRequestString, throwable);
                });
    }

    private Mono<CreateEventsResponse> onCreateEventsError(String createEventsRequestString, Throwable error) {
        return Mono.fromCallable(() -> CreateEventsRequestError.from(createEventsRequestString, error))
                .doOnNext(request -> LOG.info("ERROR REQUEST: " + request))
                .flatMap(createEventsService::createEvents);
    }
}
