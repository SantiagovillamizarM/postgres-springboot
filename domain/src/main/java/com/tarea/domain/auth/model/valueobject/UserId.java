package com.tarea.domain.auth.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record UserId(UUID value) {
    public UserId {
        Objects.requireNonNull(value, "El valor de UserId no puede ser nulo");
    }

    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }
}
