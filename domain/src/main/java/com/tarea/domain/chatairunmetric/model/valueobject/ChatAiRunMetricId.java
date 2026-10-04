package com.tarea.domain.chatairunmetric.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatAiRunMetricId(UUID value) {
    public ChatAiRunMetricId {
        Objects.requireNonNull(value, "El valor de ChatAiRunMetricId no puede ser nulo");
    }

    public static ChatAiRunMetricId generate() {
        return new ChatAiRunMetricId(UUID.randomUUID());
    }
}
