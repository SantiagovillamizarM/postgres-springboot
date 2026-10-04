package com.tarea.domain.stateregion.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;

import java.time.LocalDateTime;
import java.util.Objects;

public record StateRegionDeletedEvent(StateRegionId id, LocalDateTime occurredOn) implements DomainEvent {
    public StateRegionDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
