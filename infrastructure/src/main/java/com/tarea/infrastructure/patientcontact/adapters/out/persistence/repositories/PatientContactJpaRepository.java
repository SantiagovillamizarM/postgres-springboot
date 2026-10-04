package com.tarea.infrastructure.patientcontact.adapters.out.persistence.repositories;

import com.tarea.infrastructure.patientcontact.adapters.out.persistence.entity.PatientContactJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientContactJpaRepository extends JpaRepository<PatientContactJpaEntity, UUID> {}
