package com.tarea.infrastructure.chatairun.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateChatAiRunRequest(
        @NotNull(message = "La conversación es obligatoria")
        UUID conversationId,

        @NotNull(message = "El mensaje es obligatorio")
        UUID messageId,

        @NotNull(message = "El modelo es obligatorio")
        UUID modelId,

        @NotNull(message = "El estado es obligatorio")
        UUID aiRunStatusId
) {
}
