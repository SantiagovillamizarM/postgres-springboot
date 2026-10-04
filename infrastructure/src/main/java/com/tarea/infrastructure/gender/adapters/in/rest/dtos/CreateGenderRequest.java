package com.tarea.infrastructure.gender.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateGenderRequest(
        @NotBlank(message = "La descripción no puede estar vacía")
        @Size(max = 50, message = "La descripción no puede superar los 50 caracteres")
        String description
) {
}
