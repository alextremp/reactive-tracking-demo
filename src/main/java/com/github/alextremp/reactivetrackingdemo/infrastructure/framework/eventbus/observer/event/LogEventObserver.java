package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.eventbus.observer.event;

import com.github.alextremp.reactivetrackingdemo.domain.event.Event;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LogEventObserver {

    private static final Logger LOG = Logger.getLogger(LogEventObserver.class.getName());

    @EventListener
    void handle(Event event) {
        LOG.info("EVENT [" + event + "]");
    }
}
