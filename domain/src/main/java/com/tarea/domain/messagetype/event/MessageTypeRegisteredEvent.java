package com.tarea.domain.messagetype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MessageTypeRegisteredEvent(MessageTypeId id, LocalDateTime occurredOn) implements DomainEvent {
    public MessageTypeRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
