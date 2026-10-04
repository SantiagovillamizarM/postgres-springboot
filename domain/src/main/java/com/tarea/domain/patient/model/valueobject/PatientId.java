package com.tarea.domain.patient.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record PatientId(UUID value) {
    public PatientId {
        Objects.requireNonNull(value, "El valor de PatientId no puede ser nulo");
    }

    public static PatientId generate() {
        return new PatientId(UUID.randomUUID());
    }
}
