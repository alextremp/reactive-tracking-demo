package com.github.alextremp.reactivetrackingdemo.application.createevents;

import com.github.alextremp.reactivetrackingdemo.application.CreateEventsService;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsRequest;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsResponse;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

public class CreateEventsUseCase implements CreateEventsService {

    private static final Logger LOG = Logger.getLogger(CreateEventsService.class.getName());

    @Override
    public Mono<CreateEventsResponse> createEvents(CreateEventsRequest request) {
        return Mono.fromCallable(() -> request.toString())
                .doOnNext(clientId -> LOG.info("received::" + request))
                .map(CreateEventsResponse::new);
    }
}
