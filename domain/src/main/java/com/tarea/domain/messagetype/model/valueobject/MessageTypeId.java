package com.tarea.domain.messagetype.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record MessageTypeId(UUID value) {
    public MessageTypeId {
        Objects.requireNonNull(value, "El valor de MessageTypeId no puede ser nulo");
    }

    public static MessageTypeId generate() {
        return new MessageTypeId(UUID.randomUUID());
    }
}
