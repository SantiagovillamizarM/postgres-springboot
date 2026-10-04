package com.tarea.domain.treatmentgoal.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentGoalUpdatedEvent(
        TreatmentGoalId id,
        TreatmentPlanId treatmentPlanId,
        TreatmentGoalStatusId goalStatusId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public TreatmentGoalUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(treatmentPlanId, "El plan de tratamiento no puede ser nulo");
        Objects.requireNonNull(goalStatusId, "El estado de la meta no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
