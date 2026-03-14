package com.example.MayaFisioLumiere.Services;

import com.example.MayaFisioLumiere.entity.ExerciseSessionEntity;
import com.example.MayaFisioLumiere.repository.ExerciseSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseSessionService {
    @Autowired
    private ExerciseSessionRepository exerciseSessionRepository;
    // buscar por todas as sessões de exercicio
    public List<ExerciseSessionEntity> getAllExerciseSessions(){

    }
}
