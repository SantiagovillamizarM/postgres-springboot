package com.tarea.domain.professionalstudy.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ProfessionalStudyId(UUID value) {
    public ProfessionalStudyId {
        Objects.requireNonNull(value, "El valor de ProfessionalStudyId no puede ser nulo");
    }

    public static ProfessionalStudyId generate() {
        return new ProfessionalStudyId(UUID.randomUUID());
    }
}
