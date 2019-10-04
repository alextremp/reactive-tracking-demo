package com.github.alextremp.reactivetrackingdemo.domain.pulse;

import reactor.core.publisher.Mono;

import java.util.Map;

public class PulseFactory {

  private final PulseIdFactory pulseIdFactory;

  public PulseFactory(PulseIdFactory pulseIdFactory) {
    this.pulseIdFactory = pulseIdFactory;
  }

  public Mono<Pulse> create(String clientId, String name, Map<String, Object> payload) {
    return pulseIdFactory.createId()
        .map(id -> new Pulse(id, clientId, name, payload));
  }
}
