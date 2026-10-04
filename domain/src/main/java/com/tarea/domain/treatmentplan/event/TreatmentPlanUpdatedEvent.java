package com.tarea.domain.treatmentplan.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;

import java.time.LocalDateTime;
import java.util.Objects;

public record TreatmentPlanUpdatedEvent(
        TreatmentPlanId id,
        EncounterId encounterId,
        ProfessionalId professionalId,
        TreatmentStatusId treatmentStatusId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public TreatmentPlanUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        Objects.requireNonNull(treatmentStatusId, "El estado no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
