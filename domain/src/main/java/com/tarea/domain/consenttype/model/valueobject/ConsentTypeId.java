package com.tarea.domain.consenttype.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ConsentTypeId(UUID value) {
    public ConsentTypeId {
        Objects.requireNonNull(value, "El valor de ConsentTypeId no puede ser nulo");
    }

    public static ConsentTypeId generate() {
        return new ConsentTypeId(UUID.randomUUID());
    }
}
