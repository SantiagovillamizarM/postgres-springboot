package com.tarea.domain.encountermodality.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record EncounterModalityId(UUID value) {
    public EncounterModalityId {
        Objects.requireNonNull(value, "El valor de EncounterModalityId no puede ser nulo");
    }

    public static EncounterModalityId generate() {
        return new EncounterModalityId(UUID.randomUUID());
    }
}
