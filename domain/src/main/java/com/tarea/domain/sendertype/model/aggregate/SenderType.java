package com.tarea.domain.sendertype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.sendertype.event.SenderTypeDeletedEvent;
import com.tarea.domain.sendertype.event.SenderTypeRegisteredEvent;
import com.tarea.domain.sendertype.event.SenderTypeUpdatedEvent;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class SenderType extends AggregateRoot {
    private final SenderTypeId id;
    private String nameType;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private SenderType(SenderTypeId id, String nameType, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameType = Objects.requireNonNull(nameType, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static SenderType register(String nameType) {
        SenderTypeId id = SenderTypeId.generate();
        LocalDateTime now = LocalDateTime.now();

        SenderType senderType = new SenderType(id, nameType, now, null);
        senderType.recordEvent(new SenderTypeRegisteredEvent(id, now));
        return senderType;
    }

    public static SenderType restore(SenderTypeId id, String nameType, LocalDateTime createdAt,
                                     LocalDateTime updatedAt) {
        return new SenderType(id, nameType, createdAt, updatedAt);
    }

    public void update(String nameType) {
        this.nameType = Objects.requireNonNull(nameType, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new SenderTypeUpdatedEvent(this.id, this.nameType, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new SenderTypeDeletedEvent(this.id, LocalDateTime.now()));
    }

    public SenderTypeId id() { return id; }
    public String nameType() { return nameType; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
