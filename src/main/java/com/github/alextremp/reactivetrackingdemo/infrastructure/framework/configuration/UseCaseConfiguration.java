package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.configuration;

import com.github.alextremp.reactivetrackingdemo.application.savepulses.SavePulsesUseCase;
import com.github.alextremp.reactivetrackingdemo.domain.DomainEventBus;
import com.github.alextremp.reactivetrackingdemo.domain.pulse.PulseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

  @Bean
  public SavePulsesUseCase createEventsUseCase(DomainEventBus domainEventBus, PulseFactory pulseFactory) {
    return new SavePulsesUseCase(domainEventBus, pulseFactory);
  }
}
