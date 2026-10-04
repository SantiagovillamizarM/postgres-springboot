package com.tarea.domain.aimodel.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record AiModelId(UUID value) {
    public AiModelId {
        Objects.requireNonNull(value, "El valor de AiModelId no puede ser nulo");
    }

    public static AiModelId generate() {
        return new AiModelId(UUID.randomUUID());
    }
}
