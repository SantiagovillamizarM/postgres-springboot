package com.tarea.domain.chatconversation.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatConversationDeletedEvent(ChatConversationId id, LocalDateTime occurredOn) implements DomainEvent {
    public ChatConversationDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
