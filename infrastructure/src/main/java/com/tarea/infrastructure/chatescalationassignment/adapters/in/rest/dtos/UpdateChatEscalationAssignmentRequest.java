package com.tarea.infrastructure.chatescalationassignment.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public record UpdateChatEscalationAssignmentRequest(
        @NotNull(message = "El escalamiento es obligatorio")
        UUID escalationId,

        @NotNull(message = "El profesional es obligatorio")
        UUID professionalId,

        LocalDateTime assignedAt
) {
}
