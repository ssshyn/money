package com.sh.money.domain.plan.event;

import com.sh.money.domain.plan.enumerate.PaymentType;

import java.math.BigDecimal;

public record PaymentCreatedEvent(Long planId, PaymentType paymentType, BigDecimal amount, String memo) {
}
