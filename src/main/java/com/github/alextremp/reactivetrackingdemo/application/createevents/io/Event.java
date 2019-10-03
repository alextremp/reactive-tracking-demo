package com.github.alextremp.reactivetrackingdemo.application.createevents.io;

import java.util.LinkedHashMap;
import java.util.Map;

public class Event {
    private String name;
    private Map<String, Object> payload = new LinkedHashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
