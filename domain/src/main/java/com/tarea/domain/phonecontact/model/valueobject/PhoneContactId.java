package com.tarea.domain.phonecontact.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record PhoneContactId(UUID value) {
    public PhoneContactId {
        Objects.requireNonNull(value, "El valor de PhoneContactId no puede ser nulo");
    }

    public static PhoneContactId generate() {
        return new PhoneContactId(UUID.randomUUID());
    }
}
