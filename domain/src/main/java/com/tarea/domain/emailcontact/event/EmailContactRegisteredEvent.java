package com.tarea.domain.emailcontact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.emailcontact.model.valueobject.EmailContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EmailContactRegisteredEvent(EmailContactId id, LocalDateTime occurredOn) implements DomainEvent {
    public EmailContactRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
