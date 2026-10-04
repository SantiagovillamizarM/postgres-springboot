package com.tarea.infrastructure.phonecontact.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdatePhoneContactRequest(
        @NotNull(message = "El contacto es obligatorio")
        UUID contactId,

        @Size(max = 30, message = "El teléfono no puede superar los 30 caracteres")
        String phone,

        String notes
) {
}
