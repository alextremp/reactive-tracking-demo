package com.github.alextremp.reactivetrackingdemo.application.savepulses;

import com.github.alextremp.reactivetrackingdemo.application.SavePulsesService;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesResponse;
import com.github.alextremp.reactivetrackingdemo.domain.DomainEventBus;
import com.github.alextremp.reactivetrackingdemo.domain.pulse.PulseFactory;
import com.github.alextremp.reactivetrackingdemo.domain.pulse.event.ReceivedPulseEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class SavePulsesUseCase implements SavePulsesService {

  private final Logger LOG = Logger.getLogger(SavePulsesUseCase.class.getName());

  private final DomainEventBus domainEventBus;
  private final PulseFactory pulseFactory;

  public SavePulsesUseCase(DomainEventBus domainEventBus, PulseFactory pulseFactory) {
    this.domainEventBus = domainEventBus;
    this.pulseFactory = pulseFactory;
  }

  @Override
  public Mono<SavePulsesResponse> savePulses(SavePulsesRequest request) {
    return Flux.fromArray(request.getEvents())
        .doOnNext(event -> LOG.info("SavePulsesUseCase::" + request))
        .flatMap(event -> pulseFactory.create(request.getClientId(), event.getEventName(), event.getPayload()))
        .map(ReceivedPulseEvent::new)
        .doOnNext(domainEventBus::publish)
        .collectList()
        .map(receivedEvents -> "PROCESSED::" + receivedEvents.size())
        .map(SavePulsesResponse::new);
  }
}
