package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.eventbus.observer.event;

import com.github.alextremp.reactivetrackingdemo.domain.pulse.event.ReceivedPulseEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LogReceivedPulseEventObserver {

    private static final Logger LOG = Logger.getLogger(LogReceivedPulseEventObserver.class.getName());

    @EventListener
    void handle(ReceivedPulseEvent event) {
        LOG.info("ReceivedPulseEvent::" + event);
    }
}
