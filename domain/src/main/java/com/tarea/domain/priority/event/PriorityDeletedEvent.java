package com.tarea.domain.priority.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.priority.model.valueobject.PriorityId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PriorityDeletedEvent(PriorityId id, LocalDateTime occurredOn) implements DomainEvent {
    public PriorityDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
