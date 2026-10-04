package com.tarea.infrastructure.chatescalationstatushistory.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record CreateChatEscalationStatusHistoryRequest(
        @NotNull(message = "El escalamiento es obligatorio")
        UUID escalationId,

        @NotNull(message = "El estado es obligatorio")
        UUID escalationStatusId,

        LocalDateTime changedAt
) {
}
