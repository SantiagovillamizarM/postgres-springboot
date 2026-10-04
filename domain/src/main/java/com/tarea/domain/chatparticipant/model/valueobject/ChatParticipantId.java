package com.tarea.domain.chatparticipant.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatParticipantId(UUID value) {
    public ChatParticipantId {
        Objects.requireNonNull(value, "El valor de ChatParticipantId no puede ser nulo");
    }

    public static ChatParticipantId generate() {
        return new ChatParticipantId(UUID.randomUUID());
    }
}
