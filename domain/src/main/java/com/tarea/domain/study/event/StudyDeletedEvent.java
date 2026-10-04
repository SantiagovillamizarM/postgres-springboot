package com.tarea.domain.study.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.study.model.valueobject.StudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public record StudyDeletedEvent(StudyId id, LocalDateTime occurredOn) implements DomainEvent{
    public StudyDeletedEvent{
        Objects.requireNonNull(id, "El id no puede ser nulo");
        Objects.requireNonNull(occurredOn, "El tiempo de ocurrencia no puede ser nulo");
    }
}
