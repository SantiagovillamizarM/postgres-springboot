package com.tarea.domain.airunstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record AiRunStatusId(UUID value) {
    public AiRunStatusId {
        Objects.requireNonNull(value, "El valor de AiRunStatusId no puede ser nulo");
    }

    public static AiRunStatusId generate() {
        return new AiRunStatusId(UUID.randomUUID());
    }
}
