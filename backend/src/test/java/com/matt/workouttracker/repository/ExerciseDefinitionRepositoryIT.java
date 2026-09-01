package com.matt.workouttracker.repository;

import com.matt.workouttracker.TestcontainersConfiguration;
import com.matt.workouttracker.model.ExerciseDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(TestcontainersConfiguration.class)
class ExerciseDefinitionRepositoryIT {

    @Autowired
    private ExerciseDefinitionRepository exerciseDefinitionRepository;

    @Test
    void findByMuscleGroup_returnsOnlyExerciseDefinitionsForThatMuscleGroup() {
        ExerciseDefinition benchPress = new ExerciseDefinition();
        benchPress.setName("Bench Press IT Test");
        benchPress.setMuscleGroup("Chest");
        exerciseDefinitionRepository.save(benchPress);

        ExerciseDefinition squat = new ExerciseDefinition();
        squat.setName("Squat IT Test");
        squat.setMuscleGroup("Legs");
        exerciseDefinitionRepository.save(squat);

        List<ExerciseDefinition> results = exerciseDefinitionRepository.findByMuscleGroup("Chest");

        assertThat(results)
                .extracting(ExerciseDefinition::getName)
                .contains("Bench Press IT Test");
        assertThat(results)
                .extracting(ExerciseDefinition::getMuscleGroup)
                .containsOnly("Chest");
    }
}
