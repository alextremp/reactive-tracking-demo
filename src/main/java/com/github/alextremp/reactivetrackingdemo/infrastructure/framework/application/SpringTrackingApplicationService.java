package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.application;

import com.github.alextremp.reactivetrackingdemo.application.SavePulsesService;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.SavePulsesUseCase;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesRequest;
import com.github.alextremp.reactivetrackingdemo.application.savepulses.io.SavePulsesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Primary
@Service
public class SpringTrackingApplicationService implements SavePulsesService {

    private final SavePulsesUseCase createEventsUseCase;

    @Autowired
    public SpringTrackingApplicationService(SavePulsesUseCase createEventsUseCase) {
        this.createEventsUseCase = createEventsUseCase;
    }

    @Override
    public Mono<SavePulsesResponse> savePulses(SavePulsesRequest request) {
        return createEventsUseCase.savePulses(request);
    }
}
