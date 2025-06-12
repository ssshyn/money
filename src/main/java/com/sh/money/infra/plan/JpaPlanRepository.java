package com.sh.money.infra.plan;

import com.sh.money.infra.plan.jpa.SpringDataJpaPlanRepository;
import com.sh.money.domain.plan.entity.Plan;
import com.sh.money.domain.plan.repository.PlanRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaPlanRepository implements PlanRepository {
    private final SpringDataJpaPlanRepository jpa;

    @Override
    public Plan save(Plan plan) {
        return jpa.save(plan);
    }
}
