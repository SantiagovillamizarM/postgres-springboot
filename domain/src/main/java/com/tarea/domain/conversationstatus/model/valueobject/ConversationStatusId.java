package com.tarea.domain.conversationstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ConversationStatusId(UUID value) {
    public ConversationStatusId {
        Objects.requireNonNull(value, "El valor de ConversationStatusId no puede ser nulo");
    }

    public static ConversationStatusId generate() {
        return new ConversationStatusId(UUID.randomUUID());
    }
}
