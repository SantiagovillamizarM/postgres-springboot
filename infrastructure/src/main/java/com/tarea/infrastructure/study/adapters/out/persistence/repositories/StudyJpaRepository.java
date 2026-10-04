package com.tarea.infrastructure.study.adapters.out.persistence.repositories;

import com.tarea.infrastructure.study.adapters.out.persistence.entity.StudyJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StudyJpaRepository extends JpaRepository<StudyJpaEntity, UUID> {}
