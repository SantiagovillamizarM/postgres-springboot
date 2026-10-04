package com.tarea.domain.medicationroute.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record MedicationRouteId(UUID value) {
    public MedicationRouteId {
        Objects.requireNonNull(value, "El valor de MedicationRouteId no puede ser nulo");
    }

    public static MedicationRouteId generate() {
        return new MedicationRouteId(UUID.randomUUID());
    }
}
