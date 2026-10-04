package com.tarea.infrastructure.clinicalnote.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateClinicalNoteRequest(
        @NotNull(message = "El encuentro es obligatorio")
        UUID encounterId,

        @NotNull(message = "El profesional es obligatorio")
        UUID professionalId,

        String subjective,

        String objective,

        String assessment,

        String plan,

        String additionalNotes,

        LocalDateTime signedAt
) {
}
