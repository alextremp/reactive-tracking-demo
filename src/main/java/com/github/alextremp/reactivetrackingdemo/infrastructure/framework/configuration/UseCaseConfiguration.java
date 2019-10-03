package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.configuration;

import com.github.alextremp.reactivetrackingdemo.application.createevents.CreateEventsUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateEventsUseCase createEventsUseCase() {
        return new CreateEventsUseCase();
    }
}
