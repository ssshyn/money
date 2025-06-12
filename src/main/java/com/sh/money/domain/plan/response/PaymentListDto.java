package com.sh.money.domain.plan.response;

import com.sh.money.domain.plan.enumerate.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentListDto {
    private Long id;
    private PaymentType paymentType;
    private BigDecimal amount;
    private String memo;
    private LocalDateTime createdAt;
}
