package com.tarea.infrastructure.chatconversationaisetting.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UpdateChatConversationAiSettingRequest(
        @NotNull(message = "La conversación es obligatoria")
        UUID conversationId,

        Boolean aiEnabled,

        @NotNull(message = "El modelo por defecto es obligatorio")
        UUID defaultModelId
) {
}
