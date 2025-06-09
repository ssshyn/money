package com.sh.money.web;

import com.sh.money.application.plan.command.CreatePlanCommand;
import com.sh.money.application.plan.command.PlanCommandHandler;
import com.sh.money.domain.plan.entity.Plan;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanCommandHandler planCommandHandler;

    @PostMapping
    public ResponseEntity<?> createPlan(@RequestBody CreatePlanCommand command) {
        Plan plan = planCommandHandler.handle(command);
        return ResponseEntity.ok(Map.of("id", plan.getId()));
    }
}
