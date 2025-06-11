package com.sh.money.domain.plan.entity;

import com.sh.money.application.plan.command.CreatePaymentCommand;
import com.sh.money.core.DomainEventPublisher;
import com.sh.money.domain.plan.enumerate.PaymentType;
import com.sh.money.domain.plan.event.PaymentCreatedEvent;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(length = 255)
    private String memo;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column
    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public static Payment create(CreatePaymentCommand command, DomainEventPublisher eventPublisher) {
        Plan planRef = Plan.builder().id(command.planId()).build();
        Payment payment = Payment.builder()
                .plan(planRef)
                .paymentType(command.paymentType())
                .amount(command.amount())
                .memo(command.memo())
                .createdAt(LocalDateTime.now())
                .modifiedAt(LocalDateTime.now())
                .build();
        eventPublisher.publish(new PaymentCreatedEvent(payment.getPlan().getId(),
                payment.getPaymentType(),
                payment.getAmount(),
                payment.getMemo()));
        return payment;
    }
}
