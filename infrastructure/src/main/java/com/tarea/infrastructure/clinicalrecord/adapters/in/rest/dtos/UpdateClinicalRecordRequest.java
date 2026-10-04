package com.tarea.infrastructure.clinicalrecord.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateClinicalRecordRequest(
        @NotNull(message = "El paciente es obligatorio")
        UUID patientId,

        LocalDateTime creationDate,

        @Size(max = 50, message = "El número de historia no puede superar los 50 caracteres")
        String recordNumber,

        LocalDateTime openedAt,

        LocalDateTime closedAt,

        @NotNull(message = "El estado es obligatorio")
        UUID statusId
) {
}
