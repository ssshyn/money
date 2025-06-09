package com.sh.money.core;

public interface DomainEventPublisher {
    void publish(Object event);
}
