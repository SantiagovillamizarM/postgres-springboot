package com.tarea.domain.patientcontact.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record PatientContactId(UUID value) {
    public PatientContactId {
        Objects.requireNonNull(value, "El valor de PatientContactId no puede ser nulo");
    }

    public static PatientContactId generate() {
        return new PatientContactId(UUID.randomUUID());
    }
}
