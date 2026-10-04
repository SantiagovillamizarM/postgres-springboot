package com.tarea.domain.phonecontact.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.phonecontact.model.valueobject.PhoneContactId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PhoneContactDeletedEvent(PhoneContactId id, LocalDateTime occurredOn) implements DomainEvent {
    public PhoneContactDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
