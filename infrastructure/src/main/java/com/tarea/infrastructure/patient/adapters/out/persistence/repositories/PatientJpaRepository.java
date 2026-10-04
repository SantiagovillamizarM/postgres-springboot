package com.tarea.infrastructure.patient.adapters.out.persistence.repositories;

import com.tarea.infrastructure.patient.adapters.out.persistence.entity.PatientJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientJpaRepository extends JpaRepository<PatientJpaEntity, UUID> {
    boolean existsByEmail(String email);
}
