package com.sh.money.application.plan.command;

import com.sh.money.domain.plan.enumerate.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreatePaymentCommand(
        Long planId,
        PaymentType paymentType,
        BigDecimal amount,
        String memo,
        LocalDate paymentDate
) {
}
