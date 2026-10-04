package com.tarea.infrastructure.aimodel.adapters.out.persistence.repositories;

import com.tarea.infrastructure.aimodel.adapters.out.persistence.entity.AiModelJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AiModelJpaRepository extends JpaRepository<AiModelJpaEntity, UUID> {}
