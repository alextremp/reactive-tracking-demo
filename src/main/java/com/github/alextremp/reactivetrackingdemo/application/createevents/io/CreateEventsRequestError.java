package com.github.alextremp.reactivetrackingdemo.application.createevents.io;

public class CreateEventsRequestError {

    public static CreateEventsRequest from(String receivedRequest, Throwable error) {
        CreateEventsRequest request = new CreateEventsRequest();
        request.setClientId("reactive-tracking-demo-error");
        Event event = new Event();
        event.setName("REQUEST_ERROR");
        event.getPayload().put("receivedRequest", receivedRequest);
        event.getPayload().put("error", error);
        request.setEvents(new Event[]{event});
        return request;
    }
}
