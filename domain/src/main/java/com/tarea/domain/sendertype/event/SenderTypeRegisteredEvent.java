package com.tarea.domain.sendertype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record SenderTypeRegisteredEvent(SenderTypeId id, LocalDateTime occurredOn) implements DomainEvent {
    public SenderTypeRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
