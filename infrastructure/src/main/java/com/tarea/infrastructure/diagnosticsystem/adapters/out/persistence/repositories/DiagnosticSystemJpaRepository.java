package com.tarea.infrastructure.diagnosticsystem.adapters.out.persistence.repositories;

import com.tarea.infrastructure.diagnosticsystem.adapters.out.persistence.entity.DiagnosticSystemJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DiagnosticSystemJpaRepository extends JpaRepository<DiagnosticSystemJpaEntity, UUID> {
    boolean existsByCode(String code);
}
