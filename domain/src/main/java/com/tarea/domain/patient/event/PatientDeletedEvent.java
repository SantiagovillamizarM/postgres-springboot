package com.tarea.domain.patient.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.patient.model.valueobject.PatientId;

import java.time.LocalDateTime;
import java.util.Objects;

public record PatientDeletedEvent(PatientId id, LocalDateTime occurredOn) implements DomainEvent {
    public PatientDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
