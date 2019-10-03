package com.github.alextremp.reactivetrackingdemo.application;

import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsRequest;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsResponse;
import reactor.core.publisher.Mono;

public interface CreateEventsService {

    Mono<CreateEventsResponse> createEvents(CreateEventsRequest request);
}
