package com.tarea.domain.messagetype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MessageTypeUpdatedEvent(
        MessageTypeId id,
        String nameType,
        LocalDateTime occurredOn
) implements DomainEvent {
    public MessageTypeUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(nameType, "El nombre no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
