package com.tarea.domain.study.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.study.model.valueobject.StudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public record StudyUpdatedEvent(
        StudyId id,
        String name,
        LocalDateTime occurredOn
) implements DomainEvent {
    public StudyUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(name, "El nombre no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
