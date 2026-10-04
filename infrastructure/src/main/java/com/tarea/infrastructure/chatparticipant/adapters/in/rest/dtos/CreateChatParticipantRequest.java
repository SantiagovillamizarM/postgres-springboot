package com.tarea.infrastructure.chatparticipant.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateChatParticipantRequest(
        @NotNull(message = "La conversación es obligatoria")
        UUID conversationId,

        @NotNull(message = "El tipo de participante es obligatorio")
        UUID participantTypeId,

        UUID patientId,

        UUID professionalId
) {
}
