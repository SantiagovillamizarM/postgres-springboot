package com.tarea.domain.treatmentgoalstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record TreatmentGoalStatusId(UUID value) {
    public TreatmentGoalStatusId {
        Objects.requireNonNull(value, "El valor de TreatmentGoalStatusId no puede ser nulo");
    }

    public static TreatmentGoalStatusId generate() {
        return new TreatmentGoalStatusId(UUID.randomUUID());
    }
}
