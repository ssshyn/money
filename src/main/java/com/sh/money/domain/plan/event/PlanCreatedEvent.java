package com.sh.money.domain.plan.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PlanCreatedEvent {
    public final Integer year;
    public final Integer month;
}
