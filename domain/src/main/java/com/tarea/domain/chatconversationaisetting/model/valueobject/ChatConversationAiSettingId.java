package com.tarea.domain.chatconversationaisetting.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatConversationAiSettingId(UUID value) {
    public ChatConversationAiSettingId {
        Objects.requireNonNull(value, "El valor de ChatConversationAiSettingId no puede ser nulo");
    }

    public static ChatConversationAiSettingId generate() {
        return new ChatConversationAiSettingId(UUID.randomUUID());
    }
}
