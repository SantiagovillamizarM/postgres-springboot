package com.tarea.domain.clinicalnote.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ClinicalNoteUpdatedEvent(
        ClinicalNoteId id,
        EncounterId encounterId,
        ProfessionalId professionalId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ClinicalNoteUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(encounterId, "El encuentro no puede ser nulo");
        Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
