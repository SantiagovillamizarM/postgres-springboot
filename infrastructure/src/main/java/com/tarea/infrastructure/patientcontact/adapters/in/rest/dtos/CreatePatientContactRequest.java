package com.tarea.infrastructure.patientcontact.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreatePatientContactRequest(
        @NotNull(message = "El contacto es obligatorio")
        UUID contactId,

        @NotNull(message = "El paciente es obligatorio")
        UUID patientId,

        Boolean primaryContact,

        Boolean emergencyContact,

        @NotNull(message = "El tipo de relación es obligatorio")
        UUID relationshipTypeId
) {
}
