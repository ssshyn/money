package com.sh.money.infra.plan;

import com.sh.money.infra.plan.jpa.SpringDataJpaPaymentRepository;
import com.sh.money.domain.plan.entity.Payment;
import com.sh.money.domain.plan.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class JpaPaymentRepository implements PaymentRepository {
    private final SpringDataJpaPaymentRepository jpa;
    @Override
    public Payment save(Payment payment) {
        return jpa.save(payment);
    }
}
