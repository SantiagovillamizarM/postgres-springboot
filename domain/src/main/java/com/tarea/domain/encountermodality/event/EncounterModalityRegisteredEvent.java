package com.tarea.domain.encountermodality.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterModalityRegisteredEvent(EncounterModalityId id, LocalDateTime occurredOn) implements DomainEvent {
    public EncounterModalityRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
