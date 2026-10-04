package com.tarea.domain.escalationstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record EscalationStatusId(UUID value) {
    public EscalationStatusId {
        Objects.requireNonNull(value, "El valor de EscalationStatusId no puede ser nulo");
    }

    public static EscalationStatusId generate() {
        return new EscalationStatusId(UUID.randomUUID());
    }
}
