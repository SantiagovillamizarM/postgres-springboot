package com.tarea.infrastructure.conversationstatus.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateConversationStatusRequest(
        @NotBlank(message = "El nombre no puede estar vacío")
        @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
        String nameStatus
) {
}
