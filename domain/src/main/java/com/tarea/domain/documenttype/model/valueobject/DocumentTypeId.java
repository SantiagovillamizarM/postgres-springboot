package com.tarea.domain.documenttype.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record DocumentTypeId(UUID value) {
    public DocumentTypeId {
        Objects.requireNonNull(value, "El valor de DocumentTypeId no puede ser nulo");
    }

    public static DocumentTypeId generate() {
        return new DocumentTypeId(UUID.randomUUID());
    }
}
