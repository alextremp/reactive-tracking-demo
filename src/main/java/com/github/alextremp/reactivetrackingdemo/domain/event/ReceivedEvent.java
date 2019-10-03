package com.github.alextremp.reactivetrackingdemo.domain.event;

public class ReceivedEvent {

    private final Event event;

    public ReceivedEvent(Event event) {
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "ReceivedEvent{" +
                "event=" + event +
                '}';
    }
}
