package com.tarea.domain.encounterstatus.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public record EncounterStatusUpdatedEvent(
        EncounterStatusId id,
        String code,
        String name,
        LocalDateTime occurredOn
) implements DomainEvent {
    public EncounterStatusUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(code, "El código no puede ser nulo");
        Objects.requireNonNull(name, "El nombre no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
