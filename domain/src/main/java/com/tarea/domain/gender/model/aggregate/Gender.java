package com.tarea.domain.gender.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.gender.event.GenderDeletedEvent;
import com.tarea.domain.gender.event.GenderRegisteredEvent;
import com.tarea.domain.gender.event.GenderUpdatedEvent;
import com.tarea.domain.gender.model.valueobject.GenderId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Gender extends AggregateRoot {
    private final GenderId id;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Gender(GenderId id, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.description = Objects.requireNonNull(description, "La descripción no puede ser nula");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static Gender register(String description) {
        GenderId id = GenderId.generate();
        LocalDateTime now = LocalDateTime.now();

        Gender gender = new Gender(id, description, now, null);
        gender.recordEvent(new GenderRegisteredEvent(id, now));
        return gender;
    }

    public static Gender restore(GenderId id, String description, LocalDateTime createdAt,
                                 LocalDateTime updatedAt) {
        return new Gender(id, description, createdAt, updatedAt);
    }

    public void update(String description) {
        this.description = Objects.requireNonNull(description, "La descripción no puede ser nula");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new GenderUpdatedEvent(this.id, this.description, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new GenderDeletedEvent(this.id, LocalDateTime.now()));
    }

    public GenderId id() { return id; }
    public String description() { return description; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
