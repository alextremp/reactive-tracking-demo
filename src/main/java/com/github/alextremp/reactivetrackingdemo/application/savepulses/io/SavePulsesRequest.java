package com.github.alextremp.reactivetrackingdemo.application.savepulses.io;

import java.util.Arrays;

public class SavePulsesRequest {
  private String clientId;
  private PulseEvent[] events;

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public PulseEvent[] getEvents() {
    return events;
  }

  public void setEvents(PulseEvent[] events) {
    this.events = events;
  }

  @Override
  public String toString() {
    return "SavePulsesRequest{" +
        "clientId='" + clientId + '\'' +
        ", events=" + Arrays.toString(events) +
        '}';
  }
}
