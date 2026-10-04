package com.tarea.domain.stateregion.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record StateRegionId(UUID value) {
    public StateRegionId {
        Objects.requireNonNull(value, "El valor de StateRegionId no puede ser nulo");
    }

    public static StateRegionId generate() {
        return new StateRegionId(UUID.randomUUID());
    }
}
