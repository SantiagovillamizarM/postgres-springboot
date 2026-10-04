package com.tarea.application.diagnosticsystem.usecase;

import com.tarea.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.tarea.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.tarea.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class GetDiagnosticSystemByIdUseCase {

    private final DiagnosticSystemRepository diagnosticSystemRepository;

    public GetDiagnosticSystemByIdUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        this.diagnosticSystemRepository = diagnosticSystemRepository;
    }

    public DiagnosticSystemResponse execute(DiagnosticSystemId id) {
        var diagnosticSystem = diagnosticSystemRepository.findById(id)
                .orElseThrow(() -> new DiagnosticSystemNotFoundApplicationException(id.value().toString()));

        return new DiagnosticSystemResponse(
            diagnosticSystem.id().value(),
            diagnosticSystem.code(),
            diagnosticSystem.name(),
            diagnosticSystem.active(),
            diagnosticSystem.version(),
            diagnosticSystem.createdAt(),
            diagnosticSystem.updatedAt()
        );
    }
}
