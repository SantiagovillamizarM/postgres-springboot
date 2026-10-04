package com.tarea.domain.airunstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.airunstatus.event.AiRunStatusDeletedEvent;
import com.tarea.domain.airunstatus.event.AiRunStatusRegisteredEvent;
import com.tarea.domain.airunstatus.event.AiRunStatusUpdatedEvent;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class AiRunStatus extends AggregateRoot {
    private final AiRunStatusId id;
    private String nameStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AiRunStatus(AiRunStatusId id, String nameStatus, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameStatus = Objects.requireNonNull(nameStatus, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static AiRunStatus register(String nameStatus) {
        AiRunStatusId id = AiRunStatusId.generate();
        LocalDateTime now = LocalDateTime.now();

        AiRunStatus aiRunStatus = new AiRunStatus(id, nameStatus, now, null);
        aiRunStatus.recordEvent(new AiRunStatusRegisteredEvent(id, now));
        return aiRunStatus;
    }

    public static AiRunStatus restore(AiRunStatusId id, String nameStatus, LocalDateTime createdAt,
                                      LocalDateTime updatedAt) {
        return new AiRunStatus(id, nameStatus, createdAt, updatedAt);
    }

    public void update(String nameStatus) {
        this.nameStatus = Objects.requireNonNull(nameStatus, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new AiRunStatusUpdatedEvent(this.id, this.nameStatus, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new AiRunStatusDeletedEvent(this.id, LocalDateTime.now()));
    }

    public AiRunStatusId id() { return id; }
    public String nameStatus() { return nameStatus; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
