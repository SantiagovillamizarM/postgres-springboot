package com.tarea.domain.chatconversationaisetting.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversationaisetting.event.ChatConversationAiSettingDeletedEvent;
import com.tarea.domain.chatconversationaisetting.event.ChatConversationAiSettingRegisteredEvent;
import com.tarea.domain.chatconversationaisetting.event.ChatConversationAiSettingUpdatedEvent;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatConversationAiSetting extends AggregateRoot {
    private final ChatConversationAiSettingId id;
    private ChatConversationId conversationId;
    private boolean aiEnabled;
    private AiModelId defaultModelId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatConversationAiSetting(ChatConversationAiSettingId id, ChatConversationId conversationId,
                                      boolean aiEnabled, AiModelId defaultModelId, LocalDateTime createdAt,
                                      LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.conversationId = Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        this.aiEnabled = aiEnabled;
        this.defaultModelId = Objects.requireNonNull(defaultModelId, "El modelo por defecto no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ChatConversationAiSetting register(ChatConversationId conversationId, Boolean aiEnabled,
                                                     AiModelId defaultModelId) {
        ChatConversationAiSettingId id = ChatConversationAiSettingId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean aiEnabledValue = aiEnabled != null ? aiEnabled : true;

        ChatConversationAiSetting chatConversationAiSetting = new ChatConversationAiSetting(id,
                                                                                            conversationId,
                                                                                            aiEnabledValue,
                                                                                            defaultModelId,
                                                                                            now, null);
        chatConversationAiSetting.recordEvent(new ChatConversationAiSettingRegisteredEvent(id, now));
        return chatConversationAiSetting;
    }

    public static ChatConversationAiSetting restore(ChatConversationAiSettingId id,
                                                    ChatConversationId conversationId, boolean aiEnabled,
                                                    AiModelId defaultModelId, LocalDateTime createdAt,
                                                    LocalDateTime updatedAt) {
        return new ChatConversationAiSetting(id, conversationId, aiEnabled, defaultModelId, createdAt,
                                             updatedAt);
    }

    public void update(ChatConversationId conversationId, Boolean aiEnabled, AiModelId defaultModelId) {
        this.conversationId = Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        if (aiEnabled != null) {
            this.aiEnabled = aiEnabled;
        }
        this.defaultModelId = Objects.requireNonNull(defaultModelId, "El modelo por defecto no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ChatConversationAiSettingUpdatedEvent(this.id, this.conversationId,
                                                              this.defaultModelId, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ChatConversationAiSettingDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ChatConversationAiSettingId id() { return id; }
    public ChatConversationId conversationId() { return conversationId; }
    public boolean aiEnabled() { return aiEnabled; }
    public AiModelId defaultModelId() { return defaultModelId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
