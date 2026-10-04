package com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.repositories;

import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.entity.TreatmentStatusJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TreatmentStatusJpaRepository extends JpaRepository<TreatmentStatusJpaEntity, UUID> {
    boolean existsByCode(String code);
}
