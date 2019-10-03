package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.application;

import com.github.alextremp.reactivetrackingdemo.application.CreateEventsService;
import com.github.alextremp.reactivetrackingdemo.application.createevents.CreateEventsUseCase;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsRequest;
import com.github.alextremp.reactivetrackingdemo.application.createevents.io.CreateEventsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Primary
@Service
public class SpringTrackingApplicationService implements CreateEventsService {

    private final CreateEventsUseCase createEventsUseCase;

    @Autowired
    public SpringTrackingApplicationService(CreateEventsUseCase createEventsUseCase) {
        this.createEventsUseCase = createEventsUseCase;
    }

    @Override
    public Mono<CreateEventsResponse> createEvents(CreateEventsRequest request) {
        return createEventsUseCase.createEvents(request);
    }
}
