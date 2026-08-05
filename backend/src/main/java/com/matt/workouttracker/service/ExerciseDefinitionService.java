package com.matt.workouttracker.service;

import com.matt.workouttracker.model.ExerciseDefinition;
import com.matt.workouttracker.repository.ExerciseDefinitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseDefinitionService {
    private final ExerciseDefinitionRepository exerciseDefinitionRepository;

    public ExerciseDefinitionService(ExerciseDefinitionRepository exerciseDefinitionRepository) {
        this.exerciseDefinitionRepository = exerciseDefinitionRepository;
    }
    
    public List<ExerciseDefinition> getAllExerciseDefinitions(){
        return exerciseDefinitionRepository.findAll();
    }
}
