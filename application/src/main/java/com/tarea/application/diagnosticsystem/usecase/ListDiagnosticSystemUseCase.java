package com.tarea.application.diagnosticsystem.usecase;

import com.tarea.application.diagnosticsystem.dto.DiagnosticSystemResponse;
import com.tarea.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;

import java.util.List;

public class ListDiagnosticSystemUseCase {

    private final DiagnosticSystemRepository diagnosticSystemRepository;

    public ListDiagnosticSystemUseCase(DiagnosticSystemRepository diagnosticSystemRepository) {
        this.diagnosticSystemRepository = diagnosticSystemRepository;
    }

    public List<DiagnosticSystemResponse> execute() {
        return diagnosticSystemRepository.findAll().stream()
                .map(diagnosticSystem -> new DiagnosticSystemResponse(
                    diagnosticSystem.id().value(),
                    diagnosticSystem.code(),
                    diagnosticSystem.name(),
                    diagnosticSystem.active(),
                    diagnosticSystem.version(),
                    diagnosticSystem.createdAt(),
                    diagnosticSystem.updatedAt()
                ))
                .toList();
    }
}
