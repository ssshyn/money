package com.sh.money.infra.plan.jpa;

import com.sh.money.domain.plan.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaPlanRepository extends JpaRepository<Plan, Long> {
}
