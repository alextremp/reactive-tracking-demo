package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.alextremp.reactivetrackingdemo.application.SavePulsesService;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

  @PostMapping
  public Mono<SavePulsesResponse> savePulses(@RequestBody String createEventsRequestString) {
    return Mono.fromCallable(() -> objectMapper.readValue(createEventsRequestString, SavePulsesRequest.class))
        .subscribeOn(Schedulers.parallel())
        .flatMap(savePulsesService::savePulses)
        .doOnNext(response -> LOG.info("response: " + response));
  }
}
