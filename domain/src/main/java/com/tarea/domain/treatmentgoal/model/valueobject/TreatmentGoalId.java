package com.tarea.domain.treatmentgoal.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record TreatmentGoalId(UUID value) {
    public TreatmentGoalId {
        Objects.requireNonNull(value, "El valor de TreatmentGoalId no puede ser nulo");
    }

    public static TreatmentGoalId generate() {
        return new TreatmentGoalId(UUID.randomUUID());
    }
}
