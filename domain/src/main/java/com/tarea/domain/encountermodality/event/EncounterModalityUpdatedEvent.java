package com.tarea.domain.encountermodality.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterModalityUpdatedEvent(
        EncounterModalityId id,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
    public EncounterModalityUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(code, "El código no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
