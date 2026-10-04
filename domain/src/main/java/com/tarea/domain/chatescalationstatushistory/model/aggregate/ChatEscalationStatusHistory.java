package com.tarea.domain.chatescalationstatushistory.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryDeletedEvent;
import com.tarea.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryRegisteredEvent;
import com.tarea.domain.chatescalationstatushistory.event.ChatEscalationStatusHistoryUpdatedEvent;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ChatEscalationStatusHistory extends AggregateRoot {
    private final ChatEscalationStatusHistoryId id;
    private ChatEscalationId escalationId;
    private EscalationStatusId escalationStatusId;
    private LocalDateTime changedAt;
    private final LocalDateTime createdAt;

    private ChatEscalationStatusHistory(ChatEscalationStatusHistoryId id, ChatEscalationId escalationId,
                                        EscalationStatusId escalationStatusId, LocalDateTime changedAt,
                                        LocalDateTime createdAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.escalationId = Objects.requireNonNull(escalationId, "El escalamiento no puede ser nulo");
        this.escalationStatusId = Objects.requireNonNull(escalationStatusId, "El estado no puede ser nulo");
        this.changedAt = changedAt;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
    }

    public static ChatEscalationStatusHistory register(ChatEscalationId escalationId,
                                                       EscalationStatusId escalationStatusId,
                                                       LocalDateTime changedAt) {
        ChatEscalationStatusHistoryId id = ChatEscalationStatusHistoryId.generate();
        LocalDateTime now = LocalDateTime.now();

        ChatEscalationStatusHistory chatEscalationStatusHistory = new ChatEscalationStatusHistory(id,
                                                                                                  escalationId,
                                                                                                  escalationStatusId,
                                                                                                  changedAt,
                                                                                                  now);
        chatEscalationStatusHistory.recordEvent(new ChatEscalationStatusHistoryRegisteredEvent(id, now));
        return chatEscalationStatusHistory;
    }

    public static ChatEscalationStatusHistory restore(ChatEscalationStatusHistoryId id,
                                                      ChatEscalationId escalationId,
                                                      EscalationStatusId escalationStatusId,
                                                      LocalDateTime changedAt, LocalDateTime createdAt) {
        return new ChatEscalationStatusHistory(id, escalationId, escalationStatusId, changedAt, createdAt);
    }

    public void update(ChatEscalationId escalationId, EscalationStatusId escalationStatusId,
                       LocalDateTime changedAt) {
        this.escalationId = Objects.requireNonNull(escalationId, "El escalamiento no puede ser nulo");
        this.escalationStatusId = Objects.requireNonNull(escalationStatusId, "El estado no puede ser nulo");
        this.changedAt = changedAt;

        recordEvent(new ChatEscalationStatusHistoryUpdatedEvent(this.id, this.escalationId,
                                                                this.escalationStatusId, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new ChatEscalationStatusHistoryDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ChatEscalationStatusHistoryId id() { return id; }
    public ChatEscalationId escalationId() { return escalationId; }
    public EscalationStatusId escalationStatusId() { return escalationStatusId; }
    public LocalDateTime changedAt() { return changedAt; }
    public LocalDateTime createdAt() { return createdAt; }
}
