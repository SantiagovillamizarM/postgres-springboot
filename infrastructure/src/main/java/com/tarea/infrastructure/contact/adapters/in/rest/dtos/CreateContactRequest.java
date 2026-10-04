package com.tarea.infrastructure.contact.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateContactRequest(
        @Size(max = 200, message = "El nombre completo no puede superar los 200 caracteres")
        String fullName,

        @Size(max = 150, message = "El correo no puede superar los 150 caracteres")
        String email,

        String notes,

        @NotNull(message = "La ciudad es obligatoria")
        UUID cityId,

        @NotNull(message = "El profesional que crea es obligatorio")
        UUID createdBy,

        UUID updatedBy
) {
}
