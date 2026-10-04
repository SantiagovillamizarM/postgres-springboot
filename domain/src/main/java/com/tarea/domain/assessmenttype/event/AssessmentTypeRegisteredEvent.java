package com.tarea.domain.assessmenttype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.assessmenttype.model.valueobject.AssessmentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record AssessmentTypeRegisteredEvent(AssessmentTypeId id, LocalDateTime occurredOn) implements DomainEvent {
    public AssessmentTypeRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
