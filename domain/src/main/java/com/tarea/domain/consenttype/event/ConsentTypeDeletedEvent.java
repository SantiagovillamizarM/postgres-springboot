package com.tarea.domain.consenttype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ConsentTypeDeletedEvent(ConsentTypeId id, LocalDateTime occurredOn) implements DomainEvent {
    public ConsentTypeDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
