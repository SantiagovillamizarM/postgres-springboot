package com.tarea.infrastructure.chatescalationstatushistory.adapters.out.persistence.mappers;

import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.chatescalationstatushistory.model.aggregate.ChatEscalationStatusHistory;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.tarea.infrastructure.chatescalationstatushistory.adapters.out.persistence.entity.ChatEscalationStatusHistoryJpaEntity;

public class ChatEscalationStatusHistoryPersistenceMapper {

    public ChatEscalationStatusHistoryJpaEntity toJpa(ChatEscalationStatusHistory domain) {
        if (domain == null) {
            return null;
        }

        ChatEscalationStatusHistoryJpaEntity jpa = new ChatEscalationStatusHistoryJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setEscalationId(domain.escalationId().value());
        jpa.setEscalationStatusId(domain.escalationStatusId().value());
        jpa.setChangedAt(domain.changedAt());
        jpa.setCreatedAt(domain.createdAt());
        return jpa;
    }

    public ChatEscalationStatusHistory toDomain(ChatEscalationStatusHistoryJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return ChatEscalationStatusHistory.restore(
                new ChatEscalationStatusHistoryId(jpa.getId()),
                new ChatEscalationId(jpa.getEscalationId()),
                new EscalationStatusId(jpa.getEscalationStatusId()),
                jpa.getChangedAt(),
                jpa.getCreatedAt()
        );
    }
}
