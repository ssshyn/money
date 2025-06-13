package com.sh.money.domain.plan.event;

import com.sh.money.domain.plan.enumerate.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public record PaymentCreatedEvent(Long planId, PaymentType paymentType, BigDecimal amount, String memo, LocalDate paymentDate) {
}
