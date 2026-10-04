package com.tarea.domain.priority.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.priority.event.PriorityDeletedEvent;
import com.tarea.domain.priority.event.PriorityRegisteredEvent;
import com.tarea.domain.priority.event.PriorityUpdatedEvent;
import com.tarea.domain.priority.model.valueobject.PriorityId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Priority extends AggregateRoot {
    private final PriorityId id;
    private String namePriority;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Priority(PriorityId id, String namePriority, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.namePriority = Objects.requireNonNull(namePriority, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static Priority register(String namePriority) {
        PriorityId id = PriorityId.generate();
        LocalDateTime now = LocalDateTime.now();

        Priority priority = new Priority(id, namePriority, now, null);
        priority.recordEvent(new PriorityRegisteredEvent(id, now));
        return priority;
    }

    public static Priority restore(PriorityId id, String namePriority, LocalDateTime createdAt,
                                   LocalDateTime updatedAt) {
        return new Priority(id, namePriority, createdAt, updatedAt);
    }

    public void update(String namePriority) {
        this.namePriority = Objects.requireNonNull(namePriority, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new PriorityUpdatedEvent(this.id, this.namePriority, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new PriorityDeletedEvent(this.id, LocalDateTime.now()));
    }

    public PriorityId id() { return id; }
    public String namePriority() { return namePriority; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
