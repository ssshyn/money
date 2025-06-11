package com.sh.money.core;

import com.sh.money.domain.plan.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaPaymentRepository extends JpaRepository<Payment, Long> {
}
