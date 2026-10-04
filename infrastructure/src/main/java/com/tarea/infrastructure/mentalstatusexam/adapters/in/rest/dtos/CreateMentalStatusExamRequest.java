package com.tarea.infrastructure.mentalstatusexam.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateMentalStatusExamRequest(
        @NotNull(message = "El encuentro es obligatorio")
        UUID encounterId,

        String appearance,

        String behavior,

        String attitude,

        String consciousness,

        String orientation,

        String attention,

        String memory,

        String speech,

        String mood,

        String affect,

        String thoughtProcess,

        String thoughtContent,

        String perception,

        String judgment,

        String insight,

        String psychomotorActivity,

        String observations,

        @NotNull(message = "El profesional que crea es obligatorio")
        UUID createdBy
) {
}
