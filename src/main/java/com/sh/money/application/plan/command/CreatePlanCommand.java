package com.sh.money.application.plan.command;

import java.math.BigDecimal;

public record CreatePlanCommand(
        Integer year,
        Integer month,
        BigDecimal targetExpend
) {
}
