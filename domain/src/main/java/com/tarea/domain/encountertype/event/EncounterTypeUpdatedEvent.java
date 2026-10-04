package com.tarea.domain.encountertype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterTypeUpdatedEvent(
        EncounterTypeId id,
        String code,
        String name,
        LocalDateTime occurredOn
) implements DomainEvent {
    public EncounterTypeUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(code, "El código no puede ser nulo");
        Objects.requireNonNull(name, "El nombre no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
