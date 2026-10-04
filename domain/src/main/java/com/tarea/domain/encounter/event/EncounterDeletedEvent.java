package com.tarea.domain.encounter.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterDeletedEvent(EncounterId id, LocalDateTime occurredOn) implements DomainEvent {
    public EncounterDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
