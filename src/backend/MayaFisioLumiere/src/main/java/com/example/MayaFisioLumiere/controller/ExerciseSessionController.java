package com.example.MayaFisioLumiere.controller;

import com.example.MayaFisioLumiere.Domain.ExerciseSession.ResponseExerciseSessionDTO;
import com.example.MayaFisioLumiere.Services.ExerciseService;
import com.example.MayaFisioLumiere.entity.ExerciseSessionEntity;
import com.example.MayaFisioLumiere.repository.ExerciseSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/executeSession")
public class ExerciseSessionController {
    @Autowired
    private ExerciseSessionRepository executionRegistryRepository;
    private ExerciseSessionEntity exerciseSessionEntity;
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/getAllExecutionRegistry")
    public ResponseEntity<?>getAllExecutionRegistry(){
        List<ResponseExerciseSessionDTO> allExerciseSession = exerciseService.getAllExercises(allExerciseSession);
    }
}
