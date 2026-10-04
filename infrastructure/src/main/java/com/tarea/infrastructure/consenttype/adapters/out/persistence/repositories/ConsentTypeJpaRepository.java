package com.tarea.infrastructure.consenttype.adapters.out.persistence.repositories;

import com.tarea.infrastructure.consenttype.adapters.out.persistence.entity.ConsentTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConsentTypeJpaRepository extends JpaRepository<ConsentTypeJpaEntity, UUID> {
    boolean existsByCode(String code);
}
