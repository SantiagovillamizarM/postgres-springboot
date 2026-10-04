package com.tarea.infrastructure.chatmessage.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateChatMessageRequest(
        @NotNull(message = "La conversación es obligatoria")
        UUID conversationId,

        @NotNull(message = "El tipo de mensaje es obligatorio")
        UUID messageTypeId,

        @NotNull(message = "El participante es obligatorio")
        UUID participantId,

        String content,

        String metadata
) {
}
