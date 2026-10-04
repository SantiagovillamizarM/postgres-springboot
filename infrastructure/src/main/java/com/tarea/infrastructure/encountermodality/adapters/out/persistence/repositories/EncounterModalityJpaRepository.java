package com.tarea.infrastructure.encountermodality.adapters.out.persistence.repositories;

import com.tarea.infrastructure.encountermodality.adapters.out.persistence.entity.EncounterModalityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EncounterModalityJpaRepository extends JpaRepository<EncounterModalityJpaEntity, UUID> {
    boolean existsByCode(String code);
}
