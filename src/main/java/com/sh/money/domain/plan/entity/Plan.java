package com.sh.money.domain.plan.entity;

import com.sh.money.application.plan.command.CreatePlanCommand;
import com.sh.money.core.DomainEventPublisher;
import com.sh.money.domain.plan.event.PlanCreatedEvent;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer year;
    @Column(nullable = false)
    private Integer month;
    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;
    @Column
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Payment> payments = new ArrayList<>();

    public static Plan create(CreatePlanCommand command, DomainEventPublisher eventPublisher) {
        Plan plan = Plan.builder().year(command.year()).month(command.month()).createdAt(LocalDateTime.now()).modifiedAt(LocalDateTime.now()).build();
        eventPublisher.publish(new PlanCreatedEvent(plan.getYear(), plan.getMonth()));
        return plan;
    }

    // 편의 메서드 (양방향 연관관계 설정)
    public void addPayment(Payment payment) {
        payments.add(payment);
        payment.setPlan(this);
    }
}
