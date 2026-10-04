package com.tarea.application.diagnosticsystem.usecase;

import com.tarea.application.diagnosticsystem.command.RegisterDiagnosticSystemCommand;
import com.tarea.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.tarea.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.tarea.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

public class RegisterDiagnosticSystemUseCase {

    private final DiagnosticSystemRepository diagnosticSystemRepository;

    public RegisterDiagnosticSystemUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        this.diagnosticSystemRepository = diagnosticSystemRepository;
    }

    public DiagnosticSystemResponse execute(RegisterDiagnosticSystemCommand command) {
        DiagnosticSystem diagnosticSystem = DiagnosticSystem.register(
                command.code(),
                command.name(),
                command.active(),
                command.version()
        );

        DiagnosticSystem saved = diagnosticSystemRepository.save(diagnosticSystem);

        return new DiagnosticSystemResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.version(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
