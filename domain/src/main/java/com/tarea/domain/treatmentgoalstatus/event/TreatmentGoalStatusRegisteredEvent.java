package com.tarea.domain.treatmentgoalstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentGoalStatusRegisteredEvent(TreatmentGoalStatusId id, LocalDateTime occurredOn) implements DomainEvent {
    public TreatmentGoalStatusRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
