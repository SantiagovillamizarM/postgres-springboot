package com.tarea.infrastructure.diagnosticsystem.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateDiagnosticSystemRequest(
        @NotBlank(message = "El código no puede estar vacío")
        @Size(max = 20, message = "El código no puede superar los 20 caracteres")
        String code,

        @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
        String name,

        Boolean active,

        @Size(max = 20, message = "La versión no puede superar los 20 caracteres")
        String version
) {
}
