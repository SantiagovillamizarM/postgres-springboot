package com.tarea.domain.treatmentstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentStatusRegisteredEvent(TreatmentStatusId id, LocalDateTime occurredOn) implements DomainEvent {
    public TreatmentStatusRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
