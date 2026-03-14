package com.example.MayaFisioLumiere.repository;

import com.example.MayaFisioLumiere.entity.ExerciseSessionEntity;
import com.example.MayaFisioLumiere.entity.PatientEntity;
import com.example.MayaFisioLumiere.entity.WorkoutSessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExerciseSessionRepository extends JpaRepository<ExerciseSessionEntity, WorkoutSessionEntity> {

}
