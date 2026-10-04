package com.tarea.infrastructure.chatescalation.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateChatEscalationRequest(
        @NotNull(message = "La conversación es obligatoria")
        UUID conversationId,

        @NotNull(message = "El estado es obligatorio")
        UUID statusId,

        Boolean fromAi,

        String reason
) {
}
