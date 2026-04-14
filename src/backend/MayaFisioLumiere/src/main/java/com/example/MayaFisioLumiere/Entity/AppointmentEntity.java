package com.example.MayaFisioLumiere.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Table( name = "appointment")
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID appointment_id;

    @Column( name = "date", nullable = false)
    private LocalDateTime date;

    @Column
    private String time;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patient;

    @ManyToOne
    @JoinColumn(name = "admin_user_id")
    private AdminEntity admin;


    public void setPatient(UUID uuid) {
    }

    public void setAppointmentDate(LocalDateTime date) {
    }

    public void setAppointmentTime(String time) {
    }

    public LocalDateTime getAppointmentDate() {
    }

    public String getAppointmentTime() {
        return null;
    }
}
