package com.tarea.infrastructure.encounterstatus.adapters.out.persistence.repositories;

import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.entity.EncounterStatusJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EncounterStatusJpaRepository extends JpaRepository<EncounterStatusJpaEntity, UUID> {
    boolean existsByCode(String code);
}
