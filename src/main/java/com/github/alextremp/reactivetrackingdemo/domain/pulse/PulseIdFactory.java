package com.github.alextremp.reactivetrackingdemo.domain.pulse;

import reactor.core.publisher.Mono;

public interface PulseIdFactory {
  Mono<String> createId();
}
