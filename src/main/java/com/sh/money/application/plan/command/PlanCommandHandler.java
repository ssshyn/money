package com.sh.money.application.plan.command;

import com.sh.money.core.DomainEventPublisher;
import com.sh.money.domain.plan.entity.Plan;
import com.sh.money.domain.plan.repository.PlanRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PlanCommandHandler {
    private final PlanRepository planRepository;
    private final DomainEventPublisher domainEventPublisher;

    @Transactional
    public Plan handle(CreatePlanCommand command) {
        Plan plan = Plan.create(command, domainEventPublisher);
        return planRepository.save(plan);
    }
}
