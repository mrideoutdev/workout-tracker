package com.matt.workouttracker.repository;

import com.matt.workouttracker.model.ExerciseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseDefinitionRepository extends JpaRepository<ExerciseDefinition, Long> {
    List<ExerciseDefinition> findByMuscleGroup(String muscleGroup);
}
