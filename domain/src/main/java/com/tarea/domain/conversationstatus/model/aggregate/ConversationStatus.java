package com.tarea.domain.conversationstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.conversationstatus.event.ConversationStatusDeletedEvent;
import com.tarea.domain.conversationstatus.event.ConversationStatusRegisteredEvent;
import com.tarea.domain.conversationstatus.event.ConversationStatusUpdatedEvent;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ConversationStatus extends AggregateRoot {
    private final ConversationStatusId id;
    private String nameStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ConversationStatus(ConversationStatusId id, String nameStatus, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameStatus = Objects.requireNonNull(nameStatus, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ConversationStatus register(String nameStatus) {
        ConversationStatusId id = ConversationStatusId.generate();
        LocalDateTime now = LocalDateTime.now();

        ConversationStatus conversationStatus = new ConversationStatus(id, nameStatus, now, null);
        conversationStatus.recordEvent(new ConversationStatusRegisteredEvent(id, now));
        return conversationStatus;
    }

    public static ConversationStatus restore(ConversationStatusId id, String nameStatus,
                                             LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ConversationStatus(id, nameStatus, createdAt, updatedAt);
    }

    public void update(String nameStatus) {
        this.nameStatus = Objects.requireNonNull(nameStatus, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ConversationStatusUpdatedEvent(this.id, this.nameStatus, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ConversationStatusDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ConversationStatusId id() { return id; }
    public String nameStatus() { return nameStatus; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
