package com.matt.workouttracker.controller;

import com.matt.workouttracker.model.ExerciseDefinition;
import com.matt.workouttracker.service.ExerciseDefinitionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercise-definitions")
public class ExerciseDefinitionController {
        private final ExerciseDefinitionService exerciseDefinitionService;

    public ExerciseDefinitionController(ExerciseDefinitionService exerciseDefinitionService) {
        this.exerciseDefinitionService = exerciseDefinitionService;
    }

    @GetMapping
    public List<ExerciseDefinition> getAllExerciseDefinitions(@RequestParam(required = false) String muscleGroup) {
        return exerciseDefinitionService.getAllExerciseDefinitions(muscleGroup);
    }

    @PostMapping
    public ExerciseDefinition createExerciseDefinition(@RequestBody ExerciseDefinition exerciseDefinition) {
        return exerciseDefinitionService.createExerciseDefinition(exerciseDefinition);
    }


}
