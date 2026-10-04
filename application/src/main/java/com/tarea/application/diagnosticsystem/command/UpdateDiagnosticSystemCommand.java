package com.tarea.application.diagnosticsystem.command;

import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

public record UpdateDiagnosticSystemCommand(
        DiagnosticSystemId id,
        String code,
        String name,
        Boolean active,
        String version
) {
}
