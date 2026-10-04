package com.tarea.domain.chatconversation.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatConversationUpdatedEvent(
        ChatConversationId id,
        ConversationStatusId conversationStatusId,
        PriorityId priorityId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatConversationUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(conversationStatusId, "El estado de la conversación no puede ser nulo");
        Objects.requireNonNull(priorityId, "La prioridad no puede ser nula");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
