package com.tarea.domain.patientallergy.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record PatientAllergyId(UUID value) {
    public PatientAllergyId {
        Objects.requireNonNull(value, "El valor de PatientAllergyId no puede ser nulo");
    }

    public static PatientAllergyId generate() {
        return new PatientAllergyId(UUID.randomUUID());
    }
}
