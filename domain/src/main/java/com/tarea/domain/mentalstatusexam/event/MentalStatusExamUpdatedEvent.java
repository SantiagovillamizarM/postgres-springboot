package com.tarea.domain.mentalstatusexam.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.mentalstatusexam.model.valueobject.MentalStatusExamId;

import java.time.LocalDateTime;
import java.util.Objects;

public record MentalStatusExamUpdatedEvent(
        MentalStatusExamId id,
        EncounterId encounterId,
        ProfessionalId createdBy,
        LocalDateTime occurredOn
) implements DomainEvent {
    public MentalStatusExamUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        Objects.requireNonNull(createdBy, "El profesional que crea no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
