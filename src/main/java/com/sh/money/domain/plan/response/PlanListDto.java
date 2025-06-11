package com.sh.money.domain.plan.response;

import com.sh.money.domain.plan.entity.Payment;
import com.sh.money.domain.plan.entity.Plan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanListDto {
    private Long id;
    private Integer year;
    private Integer month;
    private LocalDateTime modifiedAt;
    private List<Payment> payments;

    public PlanListDto(Long id, Integer year, Integer month, LocalDateTime modifiedAt) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.modifiedAt = modifiedAt;
    }
}
