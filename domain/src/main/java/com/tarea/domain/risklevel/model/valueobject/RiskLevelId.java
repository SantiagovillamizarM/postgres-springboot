package com.tarea.domain.risklevel.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record RiskLevelId(UUID value) {
    public RiskLevelId {
        Objects.requireNonNull(value, "El valor de RiskLevelId no puede ser nulo");
    }

    public static RiskLevelId generate() {
        return new RiskLevelId(UUID.randomUUID());
    }
}
