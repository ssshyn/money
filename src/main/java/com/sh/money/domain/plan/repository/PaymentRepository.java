package com.sh.money.domain.plan.repository;

import com.sh.money.domain.plan.entity.Payment;

public interface PaymentRepository {
    Payment save(Payment payment);
}
