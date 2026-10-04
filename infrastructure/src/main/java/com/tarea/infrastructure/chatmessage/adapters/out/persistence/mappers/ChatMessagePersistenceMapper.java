package com.tarea.infrastructure.chatmessage.adapters.out.persistence.mappers;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;
import com.tarea.domain.chatmessage.model.aggregate.ChatMessage;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.entity.ChatMessageJpaEntity;

public class ChatMessagePersistenceMapper {

    public ChatMessageJpaEntity toJpa(ChatMessage domain) {
        if (domain == null) {
            return null;
        }

        ChatMessageJpaEntity jpa = new ChatMessageJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setConversationId(domain.conversationId().value());
        jpa.setMessageTypeId(domain.messageTypeId().value());
        jpa.setParticipantId(domain.participantId().value());
        jpa.setContent(domain.content());
        jpa.setMetadata(domain.metadata());
        jpa.setCreatedAt(domain.createdAt());
        return jpa;
    }

    public ChatMessage toDomain(ChatMessageJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return ChatMessage.restore(
                new ChatMessageId(jpa.getId()),
                new ChatConversationId(jpa.getConversationId()),
                new MessageTypeId(jpa.getMessageTypeId()),
                new ChatParticipantId(jpa.getParticipantId()),
                jpa.getContent(),
                jpa.getMetadata(),
                jpa.getCreatedAt()
        );
    }
}
