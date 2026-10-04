package com.tarea.infrastructure.patientallergy.adapters.out.persistence.repositories;

import com.tarea.infrastructure.patientallergy.adapters.out.persistence.entity.PatientAllergyJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientAllergyJpaRepository extends JpaRepository<PatientAllergyJpaEntity, UUID> {}
