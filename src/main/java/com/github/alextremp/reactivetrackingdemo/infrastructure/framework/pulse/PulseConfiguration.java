package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.pulse;

import com.github.alextremp.reactivetrackingdemo.domain.pulse.PulseFactory;
import com.github.alextremp.reactivetrackingdemo.domain.pulse.PulseIdFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PulseConfiguration {

  @Bean
  public PulseFactory pulseFactory(PulseIdFactory pulseIdFactory) {
    return new PulseFactory(pulseIdFactory);
  }

  @Bean
  PulseIdFactory pulseIdFactory() {
    return new UUIDPulseIdFactory();
  }
}
