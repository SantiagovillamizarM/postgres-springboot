package com.tarea.infrastructure.assessmenttype.adapters.out.persistence.repositories;

import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.entity.AssessmentTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AssessmentTypeJpaRepository extends JpaRepository<AssessmentTypeJpaEntity, UUID> {
    boolean existsByCode(String code);
}
