package com.example.MayaFisioLumiere.Services;

import com.example.MayaFisioLumiere.Domain.Appointment.AppointmentRequestDTO;
import com.example.MayaFisioLumiere.Domain.Appointment.AppointmentResponseDTO;
import com.example.MayaFisioLumiere.Entity.AppointmentEntity;
import com.example.MayaFisioLumiere.Entity.PatientEntity;
import com.example.MayaFisioLumiere.Repository.AppointmentRepository;
import com.example.MayaFisioLumiere.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private AppointmentEntity appointmentEntity;

    @Autowired
    private PatientRepository patientRepository;

    // criar horario dentro da maya
    public AppointmentEntity createAppointment(AppointmentRequestDTO data) {
        AppointmentEntity newAppointment = new AppointmentEntity();
        newAppointment.setDate(data.date());
        newAppointment.setTime(data.time());
        newAppointment.setPatient(data.patient_id());
        newAppointment.setDescription(data.description());

        return appointmentRepository.save(newAppointment);
    }

    // update by patient id
    public AppointmentResponseDTO updateByAppointment(AppointmentRequestDTO data, UUID patient_id, UUID appointment_id) {
        AppointmentEntity appointment = appointmentRepository.findById(appointment_id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        if (!appointment.getPatient().getPatient_ID().equals(patient_id)) {
            throw new RuntimeException("Este agendamento não pertence ao paciente informado.");
        }

        if (data.date() != null) {
            appointment.setAppointmentDate(data.date());
        }
        if (data.time() != null) {
            appointment.setAppointmentTime(data.time());
        }
        if (data.description() != null) {
            appointment.setDescription(data.description());
        }

        AppointmentEntity updatedAppointment = appointmentRepository.save(appointment);

        return new AppointmentResponseDTO(
                updatedAppointment.getAppointment_id(),
                updatedAppointment.getAppointmentDate(),
                updatedAppointment.getAppointmentTime(),
                updatedAppointment.getDescription(),
                updatedAppointment.getPatient().getPatient_ID()
        );
    }

    // get appointments by patients
    public List<AppointmentResponseDTO> getAppointmentsByPatient(UUID patient_id) {
        PatientEntity patient = patientRepository.findById(patient_id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        List<AppointmentEntity> appointments = appointmentRepository.findByPatient(patient_id);

        return appointments.stream().map(entity -> new AppointmentResponseDTO(
                entity.getAppointment_id(),
                entity.getAppointmentDate(),
                entity.getAppointmentTime(),
                entity.getDescription(),
                entity.getPatient().getPatient_ID()
        )).toList();
    }

    //get appointments by day

    public List<AppointmentResponseDTO> getAppointmentsByDay(LocalDateTime date) {
        List<AppointmentEntity> appointments = appointmentRepository.findByAppointmentDate(date);

        return appointments.stream().map(entity -> new AppointmentResponseDTO(
                entity.getAppointment_id(),
                entity.getAppointmentDate(),
                entity.getAppointmentTime(),
                entity.getDescription(),
                entity.getPatient().getPatient_ID()
        )).toList();
    }

    // get appointments by month
    public List<AppointmentResponseDTO> getAppointmentsByMonth(int month, int year) {
        List<AppointmentEntity> appointments = appointmentRepository.findAll();

        return appointments.stream()
                .filter(a -> a.getAppointmentDate().getMonthValue() == month && a.getAppointmentDate().getYear() == year)
                .map(entity -> new AppointmentResponseDTO(
                        entity.getAppointment_id(),
                        entity.getAppointmentDate(),
                        entity.getAppointmentTime(),
                        entity.getDescription(),
                        entity.getPatient().getPatient_ID()
                )).toList();
    }

    // get appointments by year
    public List<AppointmentResponseDTO> getAppointmentsByYear(int year) {
        List<AppointmentEntity> appointments = appointmentRepository.findAll();

        return appointments.stream()
                .filter(a -> a.getAppointmentDate().getYear() == year)
                .map(entity -> new AppointmentResponseDTO(
                        entity.getAppointment_id(),
                        entity.getAppointmentDate(),
                        entity.getAppointmentTime(),
                        entity.getDescription(),
                        entity.getPatient().getPatient_ID()
                )).toList();
    }

    // get all appointments
    public List<AppointmentResponseDTO> getAllAppointments() {
        List<AppointmentEntity> appointments = appointmentRepository.findAll();

        return appointments.stream().map(entity -> new AppointmentResponseDTO(
                entity.getAppointment_id(),
                entity.getAppointmentDate(),
                entity.getAppointmentTime(),
                entity.getDescription(),
                entity.getPatient().getPatient_ID()
        )).toList();
    }

    // delete appointment relacionado ao paciente
    public void deleteAppointment(UUID appointment_id, UUID patient_id) {
        AppointmentEntity appointment = appointmentRepository.findById(appointment_id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        if (!appointment.getPatient().getPatient_ID().equals(patient_id)) {
            throw new RuntimeException("Este agendamento não pertence ao paciente informado.");
        }

        appointmentRepository.delete(appointment);
    }
}
