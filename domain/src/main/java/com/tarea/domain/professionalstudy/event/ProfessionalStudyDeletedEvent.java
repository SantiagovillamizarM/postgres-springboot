package com.tarea.domain.professionalstudy.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalStudyDeletedEvent(ProfessionalStudyId id, LocalDateTime occurredOn) implements DomainEvent {
    public ProfessionalStudyDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
