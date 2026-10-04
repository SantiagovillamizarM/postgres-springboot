package com.tarea.domain.escalationstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.escalationstatus.event.EscalationStatusDeletedEvent;
import com.tarea.domain.escalationstatus.event.EscalationStatusRegisteredEvent;
import com.tarea.domain.escalationstatus.event.EscalationStatusUpdatedEvent;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EscalationStatus extends AggregateRoot {
    private final EscalationStatusId id;
    private String nameStatus;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EscalationStatus(EscalationStatusId id, String nameStatus, LocalDateTime createdAt,
                             LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.nameStatus = Objects.requireNonNull(nameStatus, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static EscalationStatus register(String nameStatus) {
        EscalationStatusId id = EscalationStatusId.generate();
        LocalDateTime now = LocalDateTime.now();

        EscalationStatus escalationStatus = new EscalationStatus(id, nameStatus, now, null);
        escalationStatus.recordEvent(new EscalationStatusRegisteredEvent(id, now));
        return escalationStatus;
    }

    public static EscalationStatus restore(EscalationStatusId id, String nameStatus, LocalDateTime createdAt,
                                           LocalDateTime updatedAt) {
        return new EscalationStatus(id, nameStatus, createdAt, updatedAt);
    }

    public void update(String nameStatus) {
        this.nameStatus = Objects.requireNonNull(nameStatus, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new EscalationStatusUpdatedEvent(this.id, this.nameStatus, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new EscalationStatusDeletedEvent(this.id, LocalDateTime.now()));
    }

    public EscalationStatusId id() { return id; }
    public String nameStatus() { return nameStatus; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
