package com.tarea.domain.risklevel.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;

import java.time.LocalDateTime;
import java.util.Objects;

public record RiskLevelUpdatedEvent(
        RiskLevelId id,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
    public RiskLevelUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(code, "El código no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
