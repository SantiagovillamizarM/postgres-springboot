package com.tarea.infrastructure.stateregion.adapters.out.persistence.repositories;

import com.tarea.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateRegionJpaRepository extends JpaRepository<StateRegionJpaEntity, UUID> {}
