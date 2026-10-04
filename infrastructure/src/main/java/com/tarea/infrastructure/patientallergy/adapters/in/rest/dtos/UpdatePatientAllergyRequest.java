package com.tarea.infrastructure.patientallergy.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdatePatientAllergyRequest(
        @NotNull(message = "El paciente es obligatorio")
        UUID patientId,

        @Size(max = 200, message = "La sustancia no puede superar los 200 caracteres")
        String substance,

        String reaction,

        @Size(max = 20, message = "La severidad no puede superar los 20 caracteres")
        String severity,

        Boolean active,

        LocalDateTime recordedAt,

        UUID recordedBy
) {
}
