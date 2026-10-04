package com.tarea.domain.treatmentstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record TreatmentStatusId(UUID value) {
    public TreatmentStatusId {
        Objects.requireNonNull(value, "El valor de TreatmentStatusId no puede ser nulo");
    }

    public static TreatmentStatusId generate() {
        return new TreatmentStatusId(UUID.randomUUID());
    }
}
