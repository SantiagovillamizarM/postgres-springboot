package com.tarea.infrastructure.treatmentplan.adapters.out.persistence.repositories;

import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.entity.TreatmentPlanJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TreatmentPlanJpaRepository extends JpaRepository<TreatmentPlanJpaEntity, UUID> {}
