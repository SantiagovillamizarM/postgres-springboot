package com.tarea.domain.professional.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ProfessionalDeletedEvent(ProfessionalId id, LocalDateTime occurredOn) implements DomainEvent {
    public ProfessionalDeletedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
