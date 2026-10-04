package com.tarea.domain.chatescalationstatushistory.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatEscalationStatusHistoryId(UUID value) {
    public ChatEscalationStatusHistoryId {
        Objects.requireNonNull(value, "El valor de ChatEscalationStatusHistoryId no puede ser nulo");
    }

    public static ChatEscalationStatusHistoryId generate() {
        return new ChatEscalationStatusHistoryId(UUID.randomUUID());
    }
}
