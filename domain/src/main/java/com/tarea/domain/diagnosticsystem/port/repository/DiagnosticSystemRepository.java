package com.tarea.domain.diagnosticsystem.port.repository;

import com.tarea.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;

import java.util.List;
import java.util.Optional;

public interface DiagnosticSystemRepository {
    DiagnosticSystem save(DiagnosticSystem diagnosticSystem);
    Optional<DiagnosticSystem> findById(DiagnosticSystemId id);
    List<DiagnosticSystem> findAll();
    boolean existsByCode(String code);
    void delete(DiagnosticSystem diagnosticSystem);
}
