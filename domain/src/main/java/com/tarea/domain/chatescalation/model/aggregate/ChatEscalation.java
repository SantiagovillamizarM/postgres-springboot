package com.tarea.domain.chatescalation.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.chatescalation.event.ChatEscalationDeletedEvent;
import com.tarea.domain.chatescalation.event.ChatEscalationRegisteredEvent;
import com.tarea.domain.chatescalation.event.ChatEscalationUpdatedEvent;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatEscalation extends AggregateRoot {
    private final ChatEscalationId id;
    private ChatConversationId conversationId;
    private EscalationStatusId statusId;
    private boolean fromAi;
    private String reason;
    private final LocalDateTime createdAt;

    private ChatEscalation(ChatEscalationId id, ChatConversationId conversationId,
                           EscalationStatusId statusId, boolean fromAi, String reason, LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.conversationId = Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        this.statusId = Objects.requireNonNull(statusId, "El estado no puede ser nulo");
        this.fromAi = fromAi;
        this.reason = reason;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
    }

    public static ChatEscalation register(ChatConversationId conversationId, EscalationStatusId statusId,
                                          Boolean fromAi, String reason) {
        ChatEscalationId id = ChatEscalationId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean fromAiValue = fromAi != null ? fromAi : false;

        ChatEscalation chatEscalation = new ChatEscalation(id, conversationId, statusId, fromAiValue, reason,
                                                           now);
        chatEscalation.recordEvent(new ChatEscalationRegisteredEvent(id, now));
        return chatEscalation;
    }

    public static ChatEscalation restore(ChatEscalationId id, ChatConversationId conversationId,
                                         EscalationStatusId statusId, boolean fromAi, String reason,
                                         LocalDateTime createdAt) {
        return new ChatEscalation(id, conversationId, statusId, fromAi, reason, createdAt);
    }

    public void update(ChatConversationId conversationId, EscalationStatusId statusId, Boolean fromAi,
                       String reason) {
        this.conversationId = Objects.requireNonNull(conversationId, "La conversación no puede ser nula");
        this.statusId = Objects.requireNonNull(statusId, "El estado no puede ser nulo");
        if (fromAi != null) {
            this.fromAi = fromAi;
        }
        this.reason = reason;

        recordEvent(new ChatEscalationUpdatedEvent(this.id, this.conversationId, this.statusId,
                                                   LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatEscalationDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ChatEscalationId id() { return id; }
    public ChatConversationId conversationId() { return conversationId; }
    public EscalationStatusId statusId() { return statusId; }
    public boolean fromAi() { return fromAi; }
    public String reason() { return reason; }
    public LocalDateTime createdAt() { return createdAt; }
}
