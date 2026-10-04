package com.tarea.application.diagnosticsystem.usecase;

import com.tarea.application.diagnosticsystem.command.UpdateDiagnosticSystemCommand;
import com.tarea.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.tarea.application.diagnosticsystem.exception.DiagnosticSystemNotFoundApplicationException;
import com.tarea.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class UpdateDiagnosticSystemUseCase {

    private final DiagnosticSystemRepository diagnosticSystemRepository;

    public UpdateDiagnosticSystemUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        this.diagnosticSystemRepository = diagnosticSystemRepository;
    }

    public DiagnosticSystemResponse execute(UpdateDiagnosticSystemCommand command) {
        var diagnosticSystem = diagnosticSystemRepository.findById(command.id())
                .orElseThrow(() -> new DiagnosticSystemNotFoundApplicationException(command.id().value().toString()));

        diagnosticSystem.update(
                command.code(),
                command.name(),
                command.active(),
                command.version()
        );

        var updated = diagnosticSystemRepository.save(diagnosticSystem);

        return new DiagnosticSystemResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.version(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
