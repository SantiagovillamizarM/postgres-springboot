package com.tarea.domain.chatairunerror.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairunerror.event.ChatAiRunErrorDeletedEvent;
import com.tarea.domain.chatairunerror.event.ChatAiRunErrorRegisteredEvent;
import com.tarea.domain.chatairunerror.event.ChatAiRunErrorUpdatedEvent;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatAiRunError extends AggregateRoot {
    private final ChatAiRunErrorId id;
    private ChatAiRunId aiRunId;
    private String errorMessage;
    private String errorCode;
    private String providerErrorId;
    private final LocalDateTime createdAt;

    private ChatAiRunError(ChatAiRunErrorId id, ChatAiRunId aiRunId, String errorMessage, String errorCode,
                           String providerErrorId, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.aiRunId = Objects.requireNonNull(aiRunId, "La ejecución de IA no puede ser nula");
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
    }

    public static ChatAiRunError register(ChatAiRunId aiRunId, String errorMessage, String errorCode,
                                          String providerErrorId) {
        ChatAiRunErrorId id = ChatAiRunErrorId.generate();
        LocalDateTime now = LocalDateTime.now();

        ChatAiRunError chatAiRunError = new ChatAiRunError(id, aiRunId, errorMessage, errorCode,
                                                           providerErrorId, now);
        chatAiRunError.recordEvent(new ChatAiRunErrorRegisteredEvent(id, now));
        return chatAiRunError;
    }

    public static ChatAiRunError restore(ChatAiRunErrorId id, ChatAiRunId aiRunId, String errorMessage,
                                         String errorCode, String providerErrorId, LocalDateTime createdAt) {
        return new ChatAiRunError(id, aiRunId, errorMessage, errorCode, providerErrorId, createdAt);
    }

    public void update(ChatAiRunId aiRunId, String errorMessage, String errorCode, String providerErrorId) {
        this.aiRunId = Objects.requireNonNull(aiRunId, "La ejecución de IA no puede ser nula");
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.providerErrorId = providerErrorId;

        recordEvent(new ChatAiRunErrorUpdatedEvent(this.id, this.aiRunId, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatAiRunErrorDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ChatAiRunErrorId id() { return id; }
    public ChatAiRunId aiRunId() { return aiRunId; }
    public String errorMessage() { return errorMessage; }
    public String errorCode() { return errorCode; }
    public String providerErrorId() { return providerErrorId; }
    public LocalDateTime createdAt() { return createdAt; }
}
