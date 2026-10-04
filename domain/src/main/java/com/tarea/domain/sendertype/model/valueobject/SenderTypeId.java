package com.tarea.domain.sendertype.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record SenderTypeId(UUID value) {
    public SenderTypeId {
        Objects.requireNonNull(value, "El valor de SenderTypeId no puede ser nulo");
    }

    public static SenderTypeId generate() {
        return new SenderTypeId(UUID.randomUUID());
    }
}
