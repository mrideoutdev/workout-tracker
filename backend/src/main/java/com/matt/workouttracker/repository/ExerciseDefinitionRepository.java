package com.matt.workouttracker.repository;

import com.matt.workouttracker.model.ExerciseDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseDefinitionRepository extends JpaRepository<ExerciseDefinition, Long> {
}
