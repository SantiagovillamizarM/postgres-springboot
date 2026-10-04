package com.tarea.domain.chatconversation.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatConversationId(UUID value) {
    public ChatConversationId {
        Objects.requireNonNull(value, "El valor de ChatConversationId no puede ser nulo");
    }

    public static ChatConversationId generate() {
        return new ChatConversationId(UUID.randomUUID());
    }
}
