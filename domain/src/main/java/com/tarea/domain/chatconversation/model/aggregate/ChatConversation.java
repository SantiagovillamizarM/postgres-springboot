package com.tarea.domain.chatconversation.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.chatconversation.event.ChatConversationDeletedEvent;
import com.tarea.domain.chatconversation.event.ChatConversationRegisteredEvent;
import com.tarea.domain.chatconversation.event.ChatConversationUpdatedEvent;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatConversation extends AggregateRoot {
    private final ChatConversationId id;
    private ConversationStatusId conversationStatusId;
    private PriorityId priorityId;
    private LocalDateTime lastMessageAt;
    private boolean closed;
    private LocalDateTime closedAt;
    private ProfessionalId closedBy;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ChatConversation(ChatConversationId id, ConversationStatusId conversationStatusId,
                             PriorityId priorityId, LocalDateTime lastMessageAt, boolean closed,
                             LocalDateTime closedAt, ProfessionalId closedBy, LocalDateTime createdAt,
                             LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.conversationStatusId = Objects.requireNonNull(conversationStatusId, "El estado de la conversación no puede ser nulo");
        this.priorityId = Objects.requireNonNull(priorityId, "La prioridad no puede ser nula");
        this.lastMessageAt = lastMessageAt;
        this.closed = closed;
        this.closedAt = closedAt;
        this.closedBy = closedBy;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ChatConversation register(ConversationStatusId conversationStatusId, PriorityId priorityId,
                                            LocalDateTime lastMessageAt, Boolean closed,
                                            LocalDateTime closedAt, ProfessionalId closedBy) {
        ChatConversationId id = ChatConversationId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean closedValue = closed != null ? closed : false;

        ChatConversation chatConversation = new ChatConversation(id, conversationStatusId, priorityId,
                                                                 lastMessageAt, closedValue, closedAt,
                                                                 closedBy, now, null);
        chatConversation.recordEvent(new ChatConversationRegisteredEvent(id, now));
        return chatConversation;
    }

    public static ChatConversation restore(ChatConversationId id, ConversationStatusId conversationStatusId,
                                           PriorityId priorityId, LocalDateTime lastMessageAt, boolean closed,
                                           LocalDateTime closedAt, ProfessionalId closedBy,
                                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ChatConversation(id, conversationStatusId, priorityId, lastMessageAt, closed, closedAt,
                                    closedBy, createdAt, updatedAt);
    }

    public void update(ConversationStatusId conversationStatusId, PriorityId priorityId,
                       LocalDateTime lastMessageAt, Boolean closed, LocalDateTime closedAt,
                       ProfessionalId closedBy) {
        this.conversationStatusId = Objects.requireNonNull(conversationStatusId, "El estado de la conversación no puede ser nulo");
        this.priorityId = Objects.requireNonNull(priorityId, "La prioridad no puede ser nula");
        this.lastMessageAt = lastMessageAt;
        if (closed != null) {
            this.closed = closed;
        }
        this.closedAt = closedAt;
        this.closedBy = closedBy;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ChatConversationUpdatedEvent(this.id, this.conversationStatusId, this.priorityId,
                                                     this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ChatConversationDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ChatConversationId id() { return id; }
    public ConversationStatusId conversationStatusId() { return conversationStatusId; }
    public PriorityId priorityId() { return priorityId; }
    public LocalDateTime lastMessageAt() { return lastMessageAt; }
    public boolean closed() { return closed; }
    public LocalDateTime closedAt() { return closedAt; }
    public ProfessionalId closedBy() { return closedBy; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
