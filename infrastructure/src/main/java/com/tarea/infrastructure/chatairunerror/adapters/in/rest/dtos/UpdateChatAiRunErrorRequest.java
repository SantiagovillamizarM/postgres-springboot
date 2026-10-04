package com.tarea.infrastructure.chatairunerror.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record UpdateChatAiRunErrorRequest(
        @NotNull(message = "La ejecución de IA es obligatoria")
        UUID aiRunId,

        String errorMessage,

        @Size(max = 80, message = "El código de error no puede superar los 80 caracteres")
        String errorCode,

        @Size(max = 120, message = "El ID de error del proveedor no puede superar los 120 caracteres")
        String providerErrorId
) {
}
