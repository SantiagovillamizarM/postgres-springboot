package com.tarea.domain.chatmessage.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatMessageUpdatedEvent(
        ChatMessageId id,
        ChatConversationId conversationId,
        MessageTypeId messageTypeId,
        ChatParticipantId participantId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatMessageUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        Objects.requireNonNull(messageTypeId, "El tipo de mensaje no puede ser nulo");
        Objects.requireNonNull(participantId, "El participante no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
