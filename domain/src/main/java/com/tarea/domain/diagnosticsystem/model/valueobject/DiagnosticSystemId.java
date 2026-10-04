package com.tarea.domain.diagnosticsystem.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record DiagnosticSystemId(UUID value) {
    public DiagnosticSystemId {
        Objects.requireNonNull(value, "El valor de DiagnosticSystemId no puede ser nulo");
    }

    public static DiagnosticSystemId generate() {
        return new DiagnosticSystemId(UUID.randomUUID());
    }
}
