package com.tarea.infrastructure.chatconversation.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateChatConversationRequest(
        @NotNull(message = "El estado de la conversación es obligatorio")
        UUID conversationStatusId,

        @NotNull(message = "La prioridad es obligatoria")
        UUID priorityId,

        LocalDateTime lastMessageAt,

        Boolean closed,

        LocalDateTime closedAt,

        UUID closedBy
) {
}
