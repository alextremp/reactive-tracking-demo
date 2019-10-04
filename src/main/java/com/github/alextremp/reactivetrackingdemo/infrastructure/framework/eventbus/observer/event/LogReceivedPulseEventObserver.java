package com.github.alextremp.reactivetrackingdemo.infrastructure.framework.eventbus.observer.event;

import com.github.alextremp.reactivetrackingdemo.domain.pulse.Pulse;
import com.github.alextremp.reactivetrackingdemo.domain.pulse.event.ReceivedPulseEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.logging.Logger;

@Component
public class LogReceivedPulseEventObserver {

  private static final Logger LOG = Logger.getLogger(LogReceivedPulseEventObserver.class.getName());

  private static final String PULSE = "PULSE";
  private static final String SEP = " | ";

  @EventListener
  void handle(ReceivedPulseEvent event) {
    Mono.fromCallable(() -> event.getPulse())
        .subscribeOn(Schedulers.parallel())
        .map(this::formattedPulse)
        .publishOn(Schedulers.elastic())
        .doOnNext(line -> LOG.info(line))
        .subscribe();
  }

  private String formattedPulse(Pulse pulse) {
    final StringBuilder sb = new StringBuilder();
    sb.append(PULSE)
        .append(SEP).append("pulse_id: ").append(pulse.getId())
        .append(SEP).append("pulse_clientId: ").append(pulse.getClientId())
        .append(SEP).append("pulse_name: ").append(pulse.getName());
    pulse.getPayload().forEach((k, v) -> sb.append(SEP).append(k).append(": ").append(v));
    return sb.toString();
  }
}
