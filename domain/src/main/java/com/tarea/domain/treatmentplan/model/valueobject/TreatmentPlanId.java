package com.tarea.domain.treatmentplan.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record TreatmentPlanId(UUID value) {
    public TreatmentPlanId {
        Objects.requireNonNull(value, "El valor de TreatmentPlanId no puede ser nulo");
    }

    public static TreatmentPlanId generate() {
        return new TreatmentPlanId(UUID.randomUUID());
    }
}
