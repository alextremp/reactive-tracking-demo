package com.github.alextremp.reactivetrackingdemo.domain.event;

import reactor.core.publisher.Mono;

public interface EventIdFactory {
    Mono<String> createId();
}
