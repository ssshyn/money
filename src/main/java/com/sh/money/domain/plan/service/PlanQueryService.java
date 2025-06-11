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
        List<PlanListDto> planListDtos = planQueryRepository.findAll();
        //todo: 여기에 Payment 리스트도 조회해서 추가 필요....
        return  planListDtos;
    }
}
