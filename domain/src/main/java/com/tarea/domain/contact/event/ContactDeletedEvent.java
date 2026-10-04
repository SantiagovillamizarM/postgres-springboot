package com.tarea.domain.contact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.contact.model.valueobject.ContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ContactDeletedEvent(ContactId id, LocalDateTime occurredOn) implements DomainEvent {
    public ContactDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
