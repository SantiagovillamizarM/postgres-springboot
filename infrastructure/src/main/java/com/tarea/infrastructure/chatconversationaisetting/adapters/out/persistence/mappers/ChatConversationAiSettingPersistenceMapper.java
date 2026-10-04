package com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.mappers;

import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversationaisetting.model.aggregate.ChatConversationAiSetting;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;
import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.entity.ChatConversationAiSettingJpaEntity;

public class ChatConversationAiSettingPersistenceMapper {

    public ChatConversationAiSettingJpaEntity toJpa(ChatConversationAiSetting domain) {
        if (domain == null) {
            return null;
        }

        ChatConversationAiSettingJpaEntity jpa = new ChatConversationAiSettingJpaEntity();
        jpa.setId(domain.id().value());
        jpa.setConversationId(domain.conversationId().value());
        jpa.setAiEnabled(domain.aiEnabled());
        jpa.setDefaultModelId(domain.defaultModelId().value());
        jpa.setCreatedAt(domain.createdAt());
        jpa.setUpdatedAt(domain.updatedAt());
        return jpa;
    }

    public ChatConversationAiSetting toDomain(ChatConversationAiSettingJpaEntity jpa) {
        if (jpa == null) {
            return null;
        }

        return ChatConversationAiSetting.restore(
                new ChatConversationAiSettingId(jpa.getId()),
                new ChatConversationId(jpa.getConversationId()),
                jpa.getAiEnabled() != null ? jpa.getAiEnabled() : true,
                new AiModelId(jpa.getDefaultModelId()),
                jpa.getCreatedAt(),
                jpa.getUpdatedAt()
        );
    }
}
