package com.github.alextremp.reactivetrackingdemo.application.createevents;

import com.github.alextremp.reactivetrackingdemo.application.CreateEventsService;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsRequest;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsResponse;
import com.github.alextremp.reactivetrackingdemo.domain.DomainEventBus;
import com.github.alextremp.reactivetrackingdemo.domain.event.EventFactory;
import com.github.alextremp.reactivetrackingdemo.domain.event.ReceivedEvent;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class CreateEventsUseCase implements CreateEventsService {

    private final Logger LOG = Logger.getLogger(CreateEventsUseCase.class.getName());

    private final DomainEventBus domainEventBus;
    private final EventFactory eventFactory;

    public CreateEventsUseCase(DomainEventBus domainEventBus, EventFactory eventFactory) {
        this.domainEventBus = domainEventBus;
        this.eventFactory = eventFactory;
    }

    @Override
    public Mono<CreateEventsResponse> createEvents(CreateEventsRequest request) {
        return Flux.fromArray(request.getEvents())
                .doOnNext(event -> LOG.info("CreateEventsUseCase::" + request))
                .flatMap(event -> eventFactory.create(request.getClientId(), event.getName(), event.getPayload()))
                .map(ReceivedEvent::new)
                .doOnNext(domainEventBus::publish)
                .collectList()
                .map(receivedEvents -> "PROCESSED::" + receivedEvents.size())
                .map(CreateEventsResponse::new);
    }
}
