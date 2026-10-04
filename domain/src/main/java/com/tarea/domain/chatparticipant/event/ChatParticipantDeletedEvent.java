package com.tarea.domain.chatparticipant.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatParticipantDeletedEvent(ChatParticipantId id, LocalDateTime occurredOn) implements DomainEvent {
    public ChatParticipantDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
