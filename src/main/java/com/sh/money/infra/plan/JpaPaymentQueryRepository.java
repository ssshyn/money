package com.sh.money.infra.plan;

import com.sh.money.domain.plan.repository.PaymentQueryRepository;
import com.sh.money.domain.plan.response.PaymentListDto;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class JpaPaymentQueryRepository implements PaymentQueryRepository {
    private final EntityManager em;

    @Override
    public List<PaymentListDto> findAll() {
        return em.createQuery(
                "SELECT new com.sh.money.domain.plan.response.PaymentListDto(p.id, p.paymentType, p.amount, p.memo, p.createdAt) FROM Payment p",
                PaymentListDto.class
        ).getResultList();
    }

    @Override
    public List<PaymentListDto> findByPlanId(Long planId) {
        return em.createQuery(
                        "SELECT new com.sh.money.domain.plan.response.PaymentListDto(p.id, p.paymentType, p.amount, p.memo, p.createdAt)" +
                                "FROM Payment p WHERE p.plan.id = :planId",
                        PaymentListDto.class
                )
                .setParameter("planId", planId)
                .getResultList();
    }
}
