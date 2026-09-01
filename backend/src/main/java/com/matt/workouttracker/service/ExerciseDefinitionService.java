package com.matt.workouttracker.service;

import com.matt.workouttracker.model.ExerciseDefinition;
import com.matt.workouttracker.repository.ExerciseDefinitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ExerciseDefinitionService {
    private final ExerciseDefinitionRepository exerciseDefinitionRepository;

    public ExerciseDefinitionService(ExerciseDefinitionRepository exerciseDefinitionRepository) {
        this.exerciseDefinitionRepository = exerciseDefinitionRepository;
    }
    
    public List<ExerciseDefinition> getAllExerciseDefinitions(String muscleGroup){
        if (Objects.isNull(muscleGroup)){
            return this.exerciseDefinitionRepository.findAll();
        } else {
            return this.exerciseDefinitionRepository.findByMuscleGroup(muscleGroup);
        }
    }

    public ExerciseDefinition createExerciseDefinition(ExerciseDefinition exerciseDefinition) {
        return exerciseDefinitionRepository.save(exerciseDefinition);
    }
}
