package com.github.alextremp.reactivetrackingdemo.domain.event;

import reactor.core.publisher.Mono;

import java.util.Map;

public class EventFactory {

    private final EventIdFactory eventIdFactory;

    public EventFactory(EventIdFactory eventIdFactory) {
        this.eventIdFactory = eventIdFactory;
    }

    public Mono<Event> create(String clientId, String name, Map<String, Object> payload) {
        return eventIdFactory.createId()
                .map(id -> new Event(id, clientId, name, payload));
    }
}
