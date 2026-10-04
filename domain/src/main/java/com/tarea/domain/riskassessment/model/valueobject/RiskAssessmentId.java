package com.tarea.domain.riskassessment.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record RiskAssessmentId(UUID value) {
    public RiskAssessmentId {
        Objects.requireNonNull(value, "El valor de RiskAssessmentId no puede ser nulo");
    }

    public static RiskAssessmentId generate() {
        return new RiskAssessmentId(UUID.randomUUID());
    }
}
