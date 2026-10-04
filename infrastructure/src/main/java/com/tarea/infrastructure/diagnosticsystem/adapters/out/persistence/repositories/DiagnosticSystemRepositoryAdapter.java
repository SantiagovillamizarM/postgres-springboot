package com.tarea.infrastructure.diagnosticsystem.adapters.out.persistence.repositories;

import com.tarea.domain.diagnosticsystem.model.aggregate.DiagnosticSystem;
import com.tarea.domain.diagnosticsystem.model.valueobject.DiagnosticSystemId;
import com.tarea.domain.diagnosticsystem.port.repository.DiagnosticSystemRepository;
import com.tarea.infrastructure.diagnosticsystem.adapters.out.persistence.entity.DiagnosticSystemJpaEntity;
import com.tarea.infrastructure.diagnosticsystem.adapters.out.persistence.mappers.DiagnosticSystemPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class DiagnosticSystemRepositoryAdapter implements DiagnosticSystemRepository {

    private final DiagnosticSystemJpaRepository diagnosticSystemJpaRepository;
    private final DiagnosticSystemPersistenceMapper mapper;

    public DiagnosticSystemRepositoryAdapter(DiagnosticSystemJpaRepository diagnosticSystemJpaRepository, DiagnosticSystemPersistenceMapper mapper) {
        this.diagnosticSystemJpaRepository = diagnosticSystemJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public DiagnosticSystem save(DiagnosticSystem diagnosticSystem) {
        DiagnosticSystemJpaEntity entity = mapper.toJpa(diagnosticSystem);
        DiagnosticSystemJpaEntity saved = diagnosticSystemJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<DiagnosticSystem> findById(DiagnosticSystemId id) {
        return diagnosticSystemJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<DiagnosticSystem> findAll() {
        return diagnosticSystemJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return diagnosticSystemJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(DiagnosticSystem diagnosticSystem) {
        diagnosticSystemJpaRepository.deleteById(diagnosticSystem.id().value());
    }
}
