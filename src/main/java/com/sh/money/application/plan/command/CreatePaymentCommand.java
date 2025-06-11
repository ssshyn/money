package com.sh.money.application.plan.command;

import com.sh.money.domain.plan.enumerate.PaymentType;

import java.math.BigDecimal;

public record CreatePaymentCommand(
        Long planId,
        PaymentType paymentType,
        BigDecimal amount,
        String memo
) {
}
