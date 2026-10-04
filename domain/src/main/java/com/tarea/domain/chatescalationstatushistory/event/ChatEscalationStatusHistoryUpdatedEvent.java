package com.tarea.domain.chatescalationstatushistory.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationStatusHistoryUpdatedEvent(
        ChatEscalationStatusHistoryId id,
        ChatEscalationId escalationId,
        EscalationStatusId escalationStatusId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatEscalationStatusHistoryUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(escalationId, "El escalamiento no puede ser nulo");
        Objects.requireNonNull(escalationStatusId, "El estado no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
