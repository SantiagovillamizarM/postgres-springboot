package com.tarea.infrastructure.risklevel.adapters.out.persistence.repositories;

import com.tarea.infrastructure.risklevel.adapters.out.persistence.entity.RiskLevelJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RiskLevelJpaRepository extends JpaRepository<RiskLevelJpaEntity, UUID> {
    boolean existsByCode(String code);
}
