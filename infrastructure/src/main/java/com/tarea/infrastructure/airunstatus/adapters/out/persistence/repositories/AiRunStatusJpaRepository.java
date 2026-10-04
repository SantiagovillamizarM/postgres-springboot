package com.tarea.infrastructure.airunstatus.adapters.out.persistence.repositories;

import com.tarea.infrastructure.airunstatus.adapters.out.persistence.entity.AiRunStatusJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AiRunStatusJpaRepository extends JpaRepository<AiRunStatusJpaEntity, UUID> {}
