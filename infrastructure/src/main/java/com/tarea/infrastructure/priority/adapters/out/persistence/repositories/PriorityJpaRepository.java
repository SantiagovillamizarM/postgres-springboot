package com.tarea.infrastructure.priority.adapters.out.persistence.repositories;

import com.tarea.infrastructure.priority.adapters.out.persistence.entity.PriorityJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PriorityJpaRepository extends JpaRepository<PriorityJpaEntity, UUID> {}
