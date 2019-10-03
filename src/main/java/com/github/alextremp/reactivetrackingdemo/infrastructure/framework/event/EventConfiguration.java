package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.event;

import com.github.alextremp.reactivetrackingdemo.domain.event.EventFactory;
import com.github.alextremp.reactivetrackingdemo.domain.event.EventIdFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfiguration {

    @Bean
    public EventFactory eventFactory(EventIdFactory eventIdFactory) {
        return new EventFactory(eventIdFactory);
    }

    @Bean EventIdFactory eventIdFactory() {
        return new UUIDEventIdFactory();
    }
}
