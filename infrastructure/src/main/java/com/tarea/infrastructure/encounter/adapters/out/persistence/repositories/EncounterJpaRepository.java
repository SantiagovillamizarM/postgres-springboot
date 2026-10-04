package com.tarea.infrastructure.encounter.adapters.out.persistence.repositories;

import com.tarea.infrastructure.encounter.adapters.out.persistence.entity.EncounterJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EncounterJpaRepository extends JpaRepository<EncounterJpaEntity, UUID> {}
