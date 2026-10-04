package com.tarea.infrastructure.medicationroute.adapters.out.persistence.repositories;

import com.tarea.infrastructure.medicationroute.adapters.out.persistence.entity.MedicationRouteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MedicationRouteJpaRepository extends JpaRepository<MedicationRouteJpaEntity, UUID> {
    boolean existsByCode(String code);
}
