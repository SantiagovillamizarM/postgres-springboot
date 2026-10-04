package com.tarea.domain.chatescalationstatushistory.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationStatusHistoryDeletedEvent(ChatEscalationStatusHistoryId id, LocalDateTime occurredOn) implements DomainEvent {
    public ChatEscalationStatusHistoryDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
