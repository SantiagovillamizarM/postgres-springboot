package com.tarea.domain.chatairun.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatAiRunId(UUID value) {
    public ChatAiRunId {
        Objects.requireNonNull(value, "El valor de ChatAiRunId no puede ser nulo");
    }

    public static ChatAiRunId generate() {
        return new ChatAiRunId(UUID.randomUUID());
    }
}
