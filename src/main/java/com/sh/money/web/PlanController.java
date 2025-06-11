package com.sh.money.web;

import com.sh.money.application.plan.command.CreatePlanCommand;
import com.sh.money.application.plan.command.PlanCommandHandler;
import com.sh.money.domain.plan.entity.Plan;
import com.sh.money.domain.plan.response.PlanListDto;
import com.sh.money.domain.plan.service.PlanQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/plans")
public class PlanController {
    private final PlanCommandHandler planCommandHandler;
    private final PlanQueryService planQueryService;

    @GetMapping
    public ResponseEntity<List<PlanListDto>> getPlans() {
        return ResponseEntity.ok(planQueryService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> createPlan(@RequestBody CreatePlanCommand command) {
        Plan plan = planCommandHandler.handle(command);
        return ResponseEntity.ok(Map.of("id", plan.getId()));
    }
}
