package com.sh.money.domain.plan.response;

import java.time.LocalDateTime;

public record PlanListDto(Long id, Integer year, Integer month, LocalDateTime modifiedAt) {
}
