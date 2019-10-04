package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.controller;

import com.github.alextremp.reactivetrackingdemo.application.SavePulsesService;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.PulseEvent;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@RestControllerAdvice
public class ControllerGlobalErrorHandler {

  private static final Logger LOG = Logger.getLogger(ControllerGlobalErrorHandler.class.getName());

  private final SavePulsesService savePulsesService;

  @Autowired
  public ControllerGlobalErrorHandler(SavePulsesService savePulsesService) {
    this.savePulsesService = savePulsesService;
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(code = HttpStatus.OK)
  public Mono<SavePulsesResponse> handleCustomException(Exception error) {
    return fromServerRequest(error)
        .doOnNext(savePulsesRequest -> LOG.info("ERROR >>> " + savePulsesRequest))
        .flatMap(savePulsesService::savePulses);
  }

  private Mono<SavePulsesRequest> fromServerRequest(Exception error) {
    return Mono.fromCallable(() -> {
      SavePulsesRequest pulse = new SavePulsesRequest();
      pulse.setClientId("reactive-tracking-demo");
      PulseEvent event = new PulseEvent();
      event.setEventName("REQUEST_ERROR");
      event.getPayload().put("error", error);
      pulse.setEvents(new PulseEvent[]{event});
      return pulse;
    });

  }

}
