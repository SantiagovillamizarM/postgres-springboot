package com.tarea.domain.encountertype.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record EncounterTypeId(UUID value) {
    public EncounterTypeId {
        Objects.requireNonNull(value, "El valor de EncounterTypeId no puede ser nulo");
    }

    public static EncounterTypeId generate() {
        return new EncounterTypeId(UUID.randomUUID());
    }
}
