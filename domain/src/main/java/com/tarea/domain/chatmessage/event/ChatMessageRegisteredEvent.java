package com.tarea.domain.chatmessage.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatMessageRegisteredEvent(ChatMessageId id, LocalDateTime occurredOn) implements DomainEvent {
    public ChatMessageRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
