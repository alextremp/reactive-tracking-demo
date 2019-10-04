package com.github.alextremp.reactivetrackingdemo.application.savepulses.io;

import java.util.LinkedHashMap;
import java.util.Map;

public class PulseEvent {
  private String eventName;
  private Map<String, Object> payload = new LinkedHashMap<>();

  public String getEventName() {
    return eventName;
  }

  public void setEventName(String eventName) {
    this.eventName = eventName;
  }

  public Map<String, Object> getPayload() {
    return payload;
  }

  public void setPayload(Map<String, Object> payload) {
    this.payload = payload;
  }

  @Override
  public String toString() {
    return "PulseEvent{" +
        "eventName='" + eventName + '\'' +
        ", payload=" + payload +
        '}';
  }
}
