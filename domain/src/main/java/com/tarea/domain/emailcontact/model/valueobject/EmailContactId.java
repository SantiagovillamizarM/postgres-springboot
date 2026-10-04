package com.tarea.domain.emailcontact.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record EmailContactId(UUID value) {
    public EmailContactId {
        Objects.requireNonNull(value, "El valor de EmailContactId no puede ser nulo");
    }

    public static EmailContactId generate() {
        return new EmailContactId(UUID.randomUUID());
    }
}
