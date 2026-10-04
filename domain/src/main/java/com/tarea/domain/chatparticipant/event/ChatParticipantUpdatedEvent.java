package com.tarea.domain.chatparticipant.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatParticipantUpdatedEvent(
        ChatParticipantId id,
        ChatConversationId conversationId,
        SenderTypeId participantTypeId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatParticipantUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        Objects.requireNonNull(participantTypeId, "El tipo de participante no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
