package com.tarea.application.treatmentplan.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record TreatmentPlanResponse(
        UUID id,
        UUID encounterId,
        UUID professionalId,
        String title,
        String description,
        LocalDate startDate,
        LocalDate endDate,
        UUID treatmentStatusId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
