package com.github.alextremp.reactivetrackingdemo.domain;

public interface DomainEventBus {

    <T> void publish(T domainEvent);
}
