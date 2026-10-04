package com.tarea.domain.priority.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record PriorityId(UUID value) {
    public PriorityId {
        Objects.requireNonNull(value, "El valor de PriorityId no puede ser nulo");
    }

    public static PriorityId generate() {
        return new PriorityId(UUID.randomUUID());
    }
}
