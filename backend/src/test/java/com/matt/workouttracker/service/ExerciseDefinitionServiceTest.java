package com.matt.workouttracker.service;

import com.matt.workouttracker.model.ExerciseDefinition;
import com.matt.workouttracker.repository.ExerciseDefinitionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExerciseDefinitionServiceTest {

    @Mock
    private ExerciseDefinitionRepository exerciseDefinitionRepository;

    @InjectMocks
    private ExerciseDefinitionService exerciseDefinitionService;

    @Test
    void getAllExerciseDefinitions_withNoMuscleGroup_returnsAllExerciseDefinitions() {
        ExerciseDefinition benchPress = new ExerciseDefinition();
        benchPress.setName("Bench Press");
        benchPress.setMuscleGroup("Chest");

        ExerciseDefinition squat = new ExerciseDefinition();
        squat.setName("Squat");
        squat.setMuscleGroup("Legs");

        when(exerciseDefinitionRepository.findAll()).thenReturn(List.of(benchPress, squat));

        List<ExerciseDefinition> result = exerciseDefinitionService.getAllExerciseDefinitions(null);

        assertThat(result).containsExactly(benchPress, squat);
        verify(exerciseDefinitionRepository).findAll();
    }

    @Test
    void getAllExerciseDefinitions_withMuscleGroup_returnsOnlyMatchingExerciseDefinitions() {
        ExerciseDefinition benchPress = new ExerciseDefinition();
        benchPress.setName("Bench Press");
        benchPress.setMuscleGroup("Chest");

        when(exerciseDefinitionRepository.findByMuscleGroup("Chest")).thenReturn(List.of(benchPress));

        List<ExerciseDefinition> result = exerciseDefinitionService.getAllExerciseDefinitions("Chest");

        assertThat(result).containsExactly(benchPress);
        verify(exerciseDefinitionRepository).findByMuscleGroup("Chest");
    }

    @Test
    void createExerciseDefinition_savesAndReturnsExerciseDefinition() {
        ExerciseDefinition toSave = new ExerciseDefinition();
        toSave.setName("Deadlift");
        toSave.setMuscleGroup("Back");

        when(exerciseDefinitionRepository.save(toSave)).thenReturn(toSave);

        ExerciseDefinition result = exerciseDefinitionService.createExerciseDefinition(toSave);

        assertThat(result).isEqualTo(toSave);
        verify(exerciseDefinitionRepository).save(toSave);
    }
}
