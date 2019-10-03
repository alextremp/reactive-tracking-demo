package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.event;

import com.github.alextremp.reactivetrackingdemo.domain.event.EventIdFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class UUIDEventIdFactory implements EventIdFactory {
    @Override
    public Mono<String> createId() {
        return Mono.fromCallable(() -> UUID.randomUUID())
                .map(uuid -> uuid.toString());
    }
}
