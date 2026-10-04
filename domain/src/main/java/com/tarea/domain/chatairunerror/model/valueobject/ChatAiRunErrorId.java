package com.tarea.domain.chatairunerror.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatAiRunErrorId(UUID value) {
    public ChatAiRunErrorId {
        Objects.requireNonNull(value, "El valor de ChatAiRunErrorId no puede ser nulo");
    }

    public static ChatAiRunErrorId generate() {
        return new ChatAiRunErrorId(UUID.randomUUID());
    }
}
