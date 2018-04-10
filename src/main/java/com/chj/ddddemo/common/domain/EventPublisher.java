package com.chj.ddddemo.common.domain;

public class EventPublisher {
    final static EventPublisher publisher = new EventPublisher();

    private EventPublisher() {}

    public static EventPublisher instance() {
        return publisher;
    }

    public void publish(DomainEvent event) {

    }

}
