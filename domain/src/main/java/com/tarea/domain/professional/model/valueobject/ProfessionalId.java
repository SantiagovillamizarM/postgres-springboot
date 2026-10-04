package com.tarea.domain.professional.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ProfessionalId(UUID value) {
    public ProfessionalId {
        Objects.requireNonNull(value, "El valor de ProfessionalId no puede ser nulo");
    }

    public static ProfessionalId generate() {
        return new ProfessionalId(UUID.randomUUID());
    }
}
