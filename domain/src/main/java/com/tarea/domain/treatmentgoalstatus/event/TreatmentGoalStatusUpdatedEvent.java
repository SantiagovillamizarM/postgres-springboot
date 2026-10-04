package com.tarea.domain.treatmentgoalstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentGoalStatusUpdatedEvent(
        TreatmentGoalStatusId id,
        String code,
        String name,
        LocalDateTime occurredOn
) implements DomainEvent {
    public TreatmentGoalStatusUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(code, "El código no puede ser nulo");
        Objects.requireNonNull(name, "El nombre no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
