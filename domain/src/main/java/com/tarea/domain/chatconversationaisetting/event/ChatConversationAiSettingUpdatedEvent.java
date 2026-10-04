package com.tarea.domain.chatconversationaisetting.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatConversationAiSettingUpdatedEvent(
        ChatConversationAiSettingId id,
        ChatConversationId conversationId,
        AiModelId defaultModelId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatConversationAiSettingUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        Objects.requireNonNull(defaultModelId, "El modelo por defecto no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
