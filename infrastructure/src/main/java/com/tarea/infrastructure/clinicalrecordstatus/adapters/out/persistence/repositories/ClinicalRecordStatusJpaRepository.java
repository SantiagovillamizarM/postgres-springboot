package com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.repositories;

import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.entity.ClinicalRecordStatusJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicalRecordStatusJpaRepository extends JpaRepository<ClinicalRecordStatusJpaEntity, UUID> {
    boolean existsByCode(String code);
}
