package com.tarea.infrastructure.treatmentgoalstatus.adapters.out.persistence.repositories;

import com.tarea.infrastructure.treatmentgoalstatus.adapters.out.persistence.entity.TreatmentGoalStatusJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TreatmentGoalStatusJpaRepository extends JpaRepository<TreatmentGoalStatusJpaEntity, UUID> {
    boolean existsByCode(String code);
}
