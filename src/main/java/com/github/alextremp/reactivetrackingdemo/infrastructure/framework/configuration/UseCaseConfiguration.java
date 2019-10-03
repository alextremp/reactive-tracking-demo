package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.configuration;

import com.github.alextremp.reactivetrackingdemo.application.createevents.CreateEventsUseCase;
import com.github.alextremp.reactivetrackingdemo.domain.DomainEventBus;
import com.github.alextremp.reactivetrackingdemo.domain.event.EventFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateEventsUseCase createEventsUseCase(DomainEventBus domainEventBus, EventFactory eventFactory) {
        return new CreateEventsUseCase(domainEventBus, eventFactory);
    }
}
