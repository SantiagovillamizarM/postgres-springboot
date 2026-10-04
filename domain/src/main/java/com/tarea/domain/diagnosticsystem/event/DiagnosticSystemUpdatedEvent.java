package com.tarea.domain.diagnosticsystem.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

import java.time.LocalDateTime;
import java.util.Objects;

public record DiagnosticSystemUpdatedEvent(
        DiagnosticSystemId id,
        String code,
        LocalDateTime occurredOn
) implements DomainEvent {
    public DiagnosticSystemUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(code, "El código no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
