package com.tarea.domain.aimodel.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;

import java.time.LocalDateTime;
import java.util.Objects;

public record AiModelDeletedEvent(AiModelId id, LocalDateTime occurredOn) implements DomainEvent {
    public AiModelDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
