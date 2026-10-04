package com.tarea.domain.professionaltype.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ProfessionalTypeId(UUID value) {
    public ProfessionalTypeId {
        Objects.requireNonNull(value, "El valor de ProfessionalTypeId no puede ser nulo");
    }

    public static ProfessionalTypeId generate() {
        return new ProfessionalTypeId(UUID.randomUUID());
    }
}
