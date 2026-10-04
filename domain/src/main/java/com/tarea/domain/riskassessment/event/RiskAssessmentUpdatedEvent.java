package com.tarea.domain.riskassessment.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;

import java.time.LocalDateTime;
import java.util.Objects;

public record RiskAssessmentUpdatedEvent(
        RiskAssessmentId id,
        EncounterId encounterId,
        RiskLevelId riskLevelId,
        ProfessionalId assessedBy,
        LocalDateTime occurredOn
) implements DomainEvent {
    public RiskAssessmentUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        Objects.requireNonNull(riskLevelId, "El nivel de riesgo no puede ser nulo");
        Objects.requireNonNull(assessedBy, "El profesional que evalúa no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
