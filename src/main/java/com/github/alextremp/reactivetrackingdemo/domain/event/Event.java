package com.github.alextremp.reactivetrackingdemo.domain.event;

import java.util.Map;

public class Event {
    private final String id;
    private final String clientId;
    private final String name;
    private final Map<String, Object> payload;

    public Event(String id, String clientId, String name, Map<String, Object> payload) {
        this.id = id;
        this.clientId = clientId;
        this.name = name;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public String getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", clientId='" + clientId + '\'' +
                ", name='" + name + '\'' +
                ", payload=" + payload +
                '}';
    }
}
