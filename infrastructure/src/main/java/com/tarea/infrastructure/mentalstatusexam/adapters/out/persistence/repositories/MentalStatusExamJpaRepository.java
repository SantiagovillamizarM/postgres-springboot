package com.tarea.infrastructure.mentalstatusexam.adapters.out.persistence.repositories;

import com.tarea.infrastructure.mentalstatusexam.adapters.out.persistence.entity.MentalStatusExamJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MentalStatusExamJpaRepository extends JpaRepository<MentalStatusExamJpaEntity, UUID> {}
