package com.sh.money.application.plan.event;

import com.sh.money.domain.plan.event.PlanCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PlanEventListener {
    @EventListener
    public void handle(PlanCreatedEvent event) {
        System.out.println("######################## event 등록");
    }
}
