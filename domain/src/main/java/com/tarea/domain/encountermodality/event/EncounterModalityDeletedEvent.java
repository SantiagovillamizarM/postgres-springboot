package com.tarea.domain.encountermodality.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterModalityDeletedEvent(EncounterModalityId id, LocalDateTime occurredOn) implements DomainEvent {
    public EncounterModalityDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
