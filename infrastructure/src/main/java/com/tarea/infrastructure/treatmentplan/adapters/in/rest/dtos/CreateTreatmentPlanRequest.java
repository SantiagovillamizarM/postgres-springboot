package com.tarea.infrastructure.treatmentplan.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.UUID;

public record CreateTreatmentPlanRequest(
        @NotNull(message = "El encuentro es obligatorio")
        UUID encounterId,

        @NotNull(message = "El profesional es obligatorio")
        UUID professionalId,

        @Size(max = 200, message = "El título no puede superar los 200 caracteres")
        String title,

        String description,

        LocalDate startDate,

        LocalDate endDate,

        @NotNull(message = "El estado es obligatorio")
        UUID treatmentStatusId
) {
}
