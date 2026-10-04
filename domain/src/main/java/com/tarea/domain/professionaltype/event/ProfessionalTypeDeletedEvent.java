package com.tarea.domain.professionaltype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalTypeDeletedEvent(ProfessionalTypeId id, LocalDateTime occurredOn) implements DomainEvent {
    public ProfessionalTypeDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
