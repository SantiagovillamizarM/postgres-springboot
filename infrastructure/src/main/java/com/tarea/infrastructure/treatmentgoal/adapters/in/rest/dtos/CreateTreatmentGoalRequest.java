package com.tarea.infrastructure.treatmentgoal.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateTreatmentGoalRequest(
        @NotNull(message = "El plan de tratamiento es obligatorio")
        UUID treatmentPlanId,

        String description,

        LocalDate targetDate,

        LocalDateTime completedAt,

        String notes,

        @NotNull(message = "El estado de la meta es obligatorio")
        UUID goalStatusId
) {
}
