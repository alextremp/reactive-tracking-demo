package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.application;

import com.github.alextremp.reactivetrackingdemo.application.TrackingApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class SpringTrackingApplication implements TrackingApplication {

  @Cacheable
  @Override
  public Mono<String> track(String data) {
    return Mono.fromCallable(() -> "hello: ")
        .map(prefix -> prefix + data);
  }
}
