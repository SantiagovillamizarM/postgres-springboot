package com.tarea.domain.chatescalation.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationRegisteredEvent(ChatEscalationId id, LocalDateTime occurredOn) implements DomainEvent {
    public ChatEscalationRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
