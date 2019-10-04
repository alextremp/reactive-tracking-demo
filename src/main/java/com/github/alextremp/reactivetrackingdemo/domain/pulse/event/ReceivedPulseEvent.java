package com.github.alextremp.reactivetrackingdemo.domain.pulse.event;

import com.github.alextremp.reactivetrackingdemo.domain.pulse.Pulse;

public class ReceivedPulseEvent {

    private final Pulse pulse;

    public ReceivedPulseEvent(Pulse pulse) {
        this.pulse = pulse;
    }

    public Pulse getPulse() {
        return pulse;
    }

    @Override
    public String toString() {
        return "ReceivedPulseEvent{" +
                "pulse=" + pulse +
                '}';
    }
}
