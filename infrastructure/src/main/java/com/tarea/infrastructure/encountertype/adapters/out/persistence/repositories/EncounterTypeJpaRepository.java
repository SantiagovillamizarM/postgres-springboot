package com.tarea.infrastructure.encountertype.adapters.out.persistence.repositories;

import com.tarea.infrastructure.encountertype.adapters.out.persistence.entity.EncounterTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EncounterTypeJpaRepository extends JpaRepository<EncounterTypeJpaEntity, UUID> {
    boolean existsByCode(String code);
}
