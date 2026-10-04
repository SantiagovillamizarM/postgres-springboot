package com.tarea.domain.messagetype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.messagetype.event.MessageTypeDeletedEvent;
import com.tarea.domain.messagetype.event.MessageTypeRegisteredEvent;
import com.tarea.domain.messagetype.event.MessageTypeUpdatedEvent;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class MessageType extends AggregateRoot {
    private final MessageTypeId id;
    private String nameType;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private MessageType(MessageTypeId id, String nameType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameType = Objects.requireNonNull(nameType, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static MessageType register(String nameType) {
        MessageTypeId id = MessageTypeId.generate();
        LocalDateTime now = LocalDateTime.now();

        MessageType messageType = new MessageType(id, nameType, now, null);
        messageType.recordEvent(new MessageTypeRegisteredEvent(id, now));
        return messageType;
    }

    public static MessageType restore(MessageTypeId id, String nameType, LocalDateTime createdAt,
                                      LocalDateTime updatedAt) {
        return new MessageType(id, nameType, createdAt, updatedAt);
    }

    public void update(String nameType) {
        this.nameType = Objects.requireNonNull(nameType, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new MessageTypeUpdatedEvent(this.id, this.nameType, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new MessageTypeDeletedEvent(this.id, LocalDateTime.now()));
    }

    public MessageTypeId id() { return id; }
    public String nameType() { return nameType; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
