package com.sh.money.infra.plan;

import com.sh.money.domain.plan.repository.PlanQueryRepository;
import com.sh.money.domain.plan.response.PlanListDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaPlanQueryRepository implements PlanQueryRepository {
    private final EntityManager em;

    @Override
    public List<PlanListDto> findAll() {
        return em.createQuery(
                "SELECT new com.sh.money.domain.plan.response.PlanListDto(p.id, p.year, p.month, p.modifiedAt) FROM Plan p",
                PlanListDto.class
        ).getResultList();
    }
}
