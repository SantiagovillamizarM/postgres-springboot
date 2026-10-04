package com.tarea.domain.chatmessage.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatMessageId(UUID value) {
    public ChatMessageId {
        Objects.requireNonNull(value, "El valor de ChatMessageId no puede ser nulo");
    }

    public static ChatMessageId generate() {
        return new ChatMessageId(UUID.randomUUID());
    }
}
