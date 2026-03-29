package com.example.MayaFisioLumiere.Domain.Login;

import java.util.UUID;

public record LoginPatientResponseDTO(
        UUID patient_id,
        String email,
        String name
) {
}
