package com.tarea.infrastructure.priority.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdatePriorityRequest(
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
        String namePriority
) {
}
