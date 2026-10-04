package com.tarea.domain.chatairun.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatairun.event.ChatAiRunDeletedEvent;
import com.tarea.domain.chatairun.event.ChatAiRunRegisteredEvent;
import com.tarea.domain.chatairun.event.ChatAiRunUpdatedEvent;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatAiRun extends AggregateRoot {
    private final ChatAiRunId id;
    private ChatConversationId conversationId;
    private ChatMessageId messageId;
    private AiModelId modelId;
    private AiRunStatusId aiRunStatusId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatAiRun(ChatAiRunId id, ChatConversationId conversationId, ChatMessageId messageId,
                      AiModelId modelId, AiRunStatusId aiRunStatusId, LocalDateTime createdAt,
                      LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.conversationId = Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        this.messageId = Objects.requireNonNull(messageId, "El mensaje no puede ser nulo");
        this.modelId = Objects.requireNonNull(modelId, "El modelo no puede ser nulo");
        this.aiRunStatusId = Objects.requireNonNull(aiRunStatusId, "El estado no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ChatAiRun register(ChatConversationId conversationId, ChatMessageId messageId,
                                     AiModelId modelId, AiRunStatusId aiRunStatusId) {
        ChatAiRunId id = ChatAiRunId.generate();
        LocalDateTime now = LocalDateTime.now();

        ChatAiRun chatAiRun = new ChatAiRun(id, conversationId, messageId, modelId, aiRunStatusId, now, null);
        chatAiRun.recordEvent(new ChatAiRunRegisteredEvent(id, now));
        return chatAiRun;
    }

    public static ChatAiRun restore(ChatAiRunId id, ChatConversationId conversationId,
                                    ChatMessageId messageId, AiModelId modelId, AiRunStatusId aiRunStatusId,
                                    LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ChatAiRun(id, conversationId, messageId, modelId, aiRunStatusId, createdAt, updatedAt);
    }

    public void update(ChatConversationId conversationId, ChatMessageId messageId, AiModelId modelId,
                       AiRunStatusId aiRunStatusId) {
        this.conversationId = Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        this.messageId = Objects.requireNonNull(messageId, "El mensaje no puede ser nulo");
        this.modelId = Objects.requireNonNull(modelId, "El modelo no puede ser nulo");
        this.aiRunStatusId = Objects.requireNonNull(aiRunStatusId, "El estado no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ChatAiRunUpdatedEvent(this.id, this.conversationId, this.messageId, this.modelId,
                                              this.aiRunStatusId, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ChatAiRunDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ChatAiRunId id() { return id; }
    public ChatConversationId conversationId() { return conversationId; }
    public ChatMessageId messageId() { return messageId; }
    public AiModelId modelId() { return modelId; }
    public AiRunStatusId aiRunStatusId() { return aiRunStatusId; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
