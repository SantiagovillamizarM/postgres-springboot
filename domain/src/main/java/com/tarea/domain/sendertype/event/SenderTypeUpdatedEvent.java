package com.tarea.domain.sendertype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record SenderTypeUpdatedEvent(
        SenderTypeId id,
        String nameType,
        LocalDateTime occurredOn
) implements DomainEvent {
    public SenderTypeUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(nameType, "El nombre no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
