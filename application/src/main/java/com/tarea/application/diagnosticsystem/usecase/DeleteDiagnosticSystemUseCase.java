package com.tarea.application.diagnosticsystem.usecase;

import com.tarea.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.tarea.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class DeleteDiagnosticSystemUseCase {

    private final DiagnosticSystemRepository diagnosticSystemRepository;

    public DeleteDiagnosticSystemUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        this.diagnosticSystemRepository = diagnosticSystemRepository;
    }

    public void execute(DiagnosticSystemId id) {
        var diagnosticSystem = diagnosticSystemRepository.findById(id)
                .orElseThrow(() -> new DiagnosticSystemNotFoundApplicationException(id.value().toString()));

        diagnosticSystem.markAsDeleted();
        diagnosticSystemRepository.delete(diagnosticSystem);
    }
}
