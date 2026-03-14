package com.example.MayaFisioLumiere.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name="workoutsession")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSessionEntity {

    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long workoutsession_id;

    @Column(nullable = false)
    private String weekDay;

    @ManyToOne
    @JoinColumn(name="patient_id",nullable = false)
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name="exercisesession_id", nullable = false)
    private ExerciseEntity exercise;
}
