package com.tarea.infrastructure.emailcontact.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateEmailContactRequest(
        @NotNull(message = "El contacto es obligatorio")
        UUID contactId,

        @NotBlank(message = "El correo no puede estar vacío")
        @Size(max = 150, message = "El correo no puede superar los 150 caracteres")
        String email,

        String notes
) {
}
