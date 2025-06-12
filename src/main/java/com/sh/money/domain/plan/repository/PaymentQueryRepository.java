package com.sh.money.domain.plan.repository;

import com.sh.money.domain.plan.response.PaymentListDto;

import java.util.List;

public interface PaymentQueryRepository {
    List<PaymentListDto> findAll();
    List<PaymentListDto> findByPlanId(Long planId);
}
