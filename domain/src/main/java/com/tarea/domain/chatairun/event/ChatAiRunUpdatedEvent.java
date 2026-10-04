package com.tarea.domain.chatairun.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatAiRunUpdatedEvent(
        ChatAiRunId id,
        ChatConversationId conversationId,
        ChatMessageId messageId,
        AiModelId modelId,
        AiRunStatusId aiRunStatusId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatAiRunUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        Objects.requireNonNull(messageId, "El mensaje no puede ser nulo");
        Objects.requireNonNull(modelId, "El modelo no puede ser nulo");
        Objects.requireNonNull(aiRunStatusId, "El estado no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
