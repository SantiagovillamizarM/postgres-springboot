package com.tarea.domain.treatmentplan.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentPlanDeletedEvent(TreatmentPlanId id, LocalDateTime occurredOn) implements DomainEvent {
    public TreatmentPlanDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
