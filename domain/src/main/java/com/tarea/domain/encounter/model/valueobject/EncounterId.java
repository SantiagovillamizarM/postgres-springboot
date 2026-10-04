package com.tarea.domain.encounter.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record EncounterId(UUID value) {
    public EncounterId {
        Objects.requireNonNull(value, "El valor de EncounterId no puede ser nulo");
    }

    public static EncounterId generate() {
        return new EncounterId(UUID.randomUUID());
    }
}
