package com.tarea.domain.medicationroute.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MedicationRouteDeletedEvent(MedicationRouteId id, LocalDateTime occurredOn) implements DomainEvent {
    public MedicationRouteDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
