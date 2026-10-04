package com.tarea.infrastructure.riskassessment.adapters.out.persistence.repositories;

import com.tarea.infrastructure.riskassessment.adapters.out.persistence.entity.RiskAssessmentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RiskAssessmentJpaRepository extends JpaRepository<RiskAssessmentJpaEntity, UUID> {}
