package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.pulse;

import com.github.alextremp.reactivetrackingdemo.domain.pulse.PulseIdFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
public class UUIDPulseIdFactory implements PulseIdFactory {
  @Override
  public Mono<String> createId() {
    return Mono.fromCallable(() -> UUID.randomUUID())
        .map(uuid -> uuid.toString());
  }
}
