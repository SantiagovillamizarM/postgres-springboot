package com.tarea.domain.chatescalation.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationUpdatedEvent(
        ChatEscalationId id,
        ChatConversationId conversationId,
        EscalationStatusId statusId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatEscalationUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        Objects.requireNonNull(statusId, "El estado no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
