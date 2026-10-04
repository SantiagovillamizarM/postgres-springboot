package com.tarea.infrastructure.clinicalnote.adapters.out.persistence.repositories;

import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.entity.ClinicalNoteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClinicalNoteJpaRepository extends JpaRepository<ClinicalNoteJpaEntity, UUID> {}
