package com.personal.travel_planner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.travel_planner.entity.Step;
import com.personal.travel_planner.service.StepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/steps")
public class StepController {
    @Autowired
    private StepService stepService;

    @GetMapping("/{id}")
    public Step getMethodName(@PathVariable Integer id) {
        return stepService.getStepById(id);
    }
    
    @PostMapping
    public Step saveStep(@RequestBody Step step) {
        return stepService.saveStep(step);
    }
    
}
