package com.tarea.infrastructure.encounter.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateEncounterRequest(
        @NotNull(message = "La historia clínica es obligatoria")
        UUID clinicalRecordId,

        @NotNull(message = "El profesional es obligatorio")
        UUID professionalId,

        @NotNull(message = "El tipo de encuentro es obligatorio")
        UUID encounterTypeId,

        LocalDateTime startedAt,

        LocalDateTime endedAt,

        String reasonForVisit,

        String currentCondition,

        @NotNull(message = "La modalidad es obligatoria")
        UUID modalityId,

        @NotNull(message = "El estado es obligatorio")
        UUID statusId,

        UUID updatedBy
) {
}
