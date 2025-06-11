package com.sh.money.domain.plan.repository;

import com.sh.money.domain.plan.response.PlanListDto;

import java.util.List;

public interface PlanQueryRepository {
    List<PlanListDto> findAll();
}
