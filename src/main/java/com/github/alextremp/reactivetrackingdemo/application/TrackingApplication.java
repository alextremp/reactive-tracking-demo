package com.github.alextremp.reactivetrackingdemo.application;

import reactor.core.publisher.Mono;

public interface TrackingApplication {

  Mono<String> track(String data);
}
