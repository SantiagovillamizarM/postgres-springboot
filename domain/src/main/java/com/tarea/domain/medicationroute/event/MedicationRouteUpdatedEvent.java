package com.tarea.domain.medicationroute.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.medicationroute.model.valueobject.MedicationRouteId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MedicationRouteUpdatedEvent(
        MedicationRouteId id,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
    public MedicationRouteUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(code, "El código no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
