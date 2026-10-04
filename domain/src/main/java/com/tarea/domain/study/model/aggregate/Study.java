package com.tarea.domain.study.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.study.event.StudyDeletedEvent;
import com.tarea.domain.study.event.StudyRegisteredEvent;
import com.tarea.domain.study.event.StudyUpdatedEvent;
import com.tarea.domain.study.model.valueobject.StudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public class Study extends AggregateRoot {
    private final StudyId id;
    private String name;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Study(StudyId id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static Study register(String name) {
        StudyId id = StudyId.generate();
        LocalDateTime now = LocalDateTime.now();

        Study study = new Study(id, name, now, null);
        study.recordEvent(new StudyRegisteredEvent(id, now));
        return study;
    }

    public static Study restore(StudyId id, String name, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new Study(id, name, createdAt, updatedAt);
    }

    public void update(String name) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new StudyUpdatedEvent(this.id, this.name, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new StudyDeletedEvent(this.id, LocalDateTime.now()));
    }

    public StudyId id() { return id; }
    public String name() { return name; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
