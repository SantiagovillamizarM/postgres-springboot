package com.tarea.infrastructure.professionaltype.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateProfessionalTypeRequest(
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(max = 40, message = "El nombre no puede superar los 40 caracteres")
        String name
) {
}
