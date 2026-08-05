package com.matt.workouttracker.controller;

import com.matt.workouttracker.model.ExerciseDefinition;
import com.matt.workouttracker.service.ExerciseDefinitionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exercise-definitions")
public class ExerciseDefinitionController {
        private final ExerciseDefinitionService exerciseDefinitionService;

    public ExerciseDefinitionController(ExerciseDefinitionService exerciseDefinitionService) {
        this.exerciseDefinitionService = exerciseDefinitionService;
    }

    @GetMapping
    public List<ExerciseDefinition> getAllExerciseDefinitions() {
        return exerciseDefinitionService.getAllExerciseDefinitions();
    }


}
