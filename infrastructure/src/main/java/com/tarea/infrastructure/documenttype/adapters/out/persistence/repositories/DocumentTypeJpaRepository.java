package com.tarea.infrastructure.documenttype.adapters.out.persistence.repositories;

import com.tarea.infrastructure.documenttype.adapters.out.persistence.entity.DocumentTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentTypeJpaRepository extends JpaRepository<DocumentTypeJpaEntity, UUID> {
    boolean existsByCode(String code);
}
