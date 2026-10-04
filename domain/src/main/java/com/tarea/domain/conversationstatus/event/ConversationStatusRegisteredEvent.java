package com.tarea.domain.conversationstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ConversationStatusRegisteredEvent(ConversationStatusId id, LocalDateTime occurredOn) implements DomainEvent {
    public ConversationStatusRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
