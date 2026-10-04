package com.tarea.infrastructure.chatconversation.adapters.out.persistence.mappers;

import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.chatconversation.model.aggregate.ChatConversation;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationJpaEntity;

public class ChatConversationPersistenceMapper {

    public ChatConversationJpaEntity toJpa(ChatConversation domain) {
        if (domain == null) {
            return null;
        }

        ChatConversationJpaEntity jpa = new ChatConversationJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setConversationStatusId(domain.conversationStatusId().value());
        jpa.setPriorityId(domain.priorityId().value());
        jpa.setLastMessageAt(domain.lastMessageAt());
        jpa.setClosed(domain.closed());
        jpa.setClosedAt(domain.closedAt());
        jpa.setClosedBy(domain.closedBy() != null ? domain.closedBy().value() : null);
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public ChatConversation toDomain(ChatConversationJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return ChatConversation.restore(
                new ChatConversationId(jpa.getId()),
                new ConversationStatusId(jpa.getConversationStatusId()),
                new PriorityId(jpa.getPriorityId()),
                jpa.getLastMessageAt(),
                jpa.getClosed() != null ? jpa.getClosed() : false,
                jpa.getClosedAt(),
                jpa.getClosedBy() != null ? new ProfessionalId(jpa.getClosedBy()) : null,
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
