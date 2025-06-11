package com.sh.money.domain.plan.service;

import com.sh.money.domain.plan.repository.PlanQueryRepository;
import com.sh.money.domain.plan.response.PlanListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PlanQueryService {
    private final PlanQueryRepository planQueryRepository;

    public List<PlanListDto> findAll() {
        return planQueryRepository.findAll();
    }
}
