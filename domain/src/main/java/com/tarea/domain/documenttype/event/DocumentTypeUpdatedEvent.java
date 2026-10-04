package com.tarea.domain.documenttype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record DocumentTypeUpdatedEvent(
        DocumentTypeId id,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
    public DocumentTypeUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(code, "El código no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
