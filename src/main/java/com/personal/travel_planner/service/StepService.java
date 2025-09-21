package com.personal.travel_planner.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.travel_planner.entity.Step;
import com.personal.travel_planner.repository.StepRepository;

@Service
public class StepService {
    @Autowired
    private StepRepository stepRepository;

    public Step getStepById(Integer id){
        return stepRepository.findById(id).orElseThrow();
    }

    public Step saveStep(Step step){
        return stepRepository.save(step);
    }

    public Iterable<Step> getAllSteps(){
        return stepRepository.findAll();
    }

}
