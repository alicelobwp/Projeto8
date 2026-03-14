package com.example.MayaFisioLumiere.Domain.ExerciseSession;

import java.util.UUID;

public record RequestExerciseSessionDTO(
        Long exercise_id,
        Long workoutsession_id,
        UUID patient_id,
        String serie
        ) { }
