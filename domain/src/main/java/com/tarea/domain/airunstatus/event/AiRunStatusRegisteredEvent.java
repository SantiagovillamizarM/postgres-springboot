package com.tarea.domain.airunstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record AiRunStatusRegisteredEvent(AiRunStatusId id, LocalDateTime occurredOn) implements DomainEvent {
    public AiRunStatusRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
