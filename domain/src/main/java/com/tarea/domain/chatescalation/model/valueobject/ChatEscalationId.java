package com.tarea.domain.chatescalation.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatEscalationId(UUID value) {
    public ChatEscalationId {
        Objects.requireNonNull(value, "El valor de ChatEscalationId no puede ser nulo");
    }

    public static ChatEscalationId generate() {
        return new ChatEscalationId(UUID.randomUUID());
    }
}
