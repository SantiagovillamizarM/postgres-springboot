package com.tarea.domain.contact.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ContactId(UUID value) {
    public ContactId {
        Objects.requireNonNull(value, "El valor de ContactId no puede ser nulo");
    }

    public static ContactId generate() {
        return new ContactId(UUID.randomUUID());
    }
}
