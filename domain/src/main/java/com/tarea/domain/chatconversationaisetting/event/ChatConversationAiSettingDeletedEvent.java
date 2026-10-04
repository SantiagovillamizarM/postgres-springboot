package com.tarea.domain.chatconversationaisetting.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatConversationAiSettingDeletedEvent(ChatConversationAiSettingId id, LocalDateTime occurredOn) implements DomainEvent {
    public ChatConversationAiSettingDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
