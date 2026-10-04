package com.tarea.domain.assessmenttype.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record AssessmentTypeId(UUID value) {
    public AssessmentTypeId {
        Objects.requireNonNull(value, "El valor de AssessmentTypeId no puede ser nulo");
    }

    public static AssessmentTypeId generate() {
        return new AssessmentTypeId(UUID.randomUUID());
    }
}
