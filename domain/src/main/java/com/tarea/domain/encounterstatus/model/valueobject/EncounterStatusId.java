package com.tarea.domain.encounterstatus.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record EncounterStatusId(UUID value) {
    public EncounterStatusId {
        Objects.requireNonNull(value, "El valor de EncounterStatusId no puede ser nulo");
    }

    public static EncounterStatusId generate() {
        return new EncounterStatusId(UUID.randomUUID());
    }
}
