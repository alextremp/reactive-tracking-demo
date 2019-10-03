package com.github.alextremp.reactivetrackingdemo.application.createevents.io;

import java.util.Arrays;

public class CreateEventsRequest {
    private String clientId;
    private Event[] events;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Event[] getEvents() {
        return events;
    }

    public void setEvents(Event[] events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "CreateEventsRequest{" +
                "clientId='" + clientId + '\'' +
                ", events=" + Arrays.toString(events) +
                '}';
    }
}
