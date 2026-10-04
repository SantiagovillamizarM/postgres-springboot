package com.tarea.infrastructure.escalationstatus.adapters.out.persistence.repositories;

import com.tarea.infrastructure.escalationstatus.adapters.out.persistence.entity.EscalationStatusJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EscalationStatusJpaRepository extends JpaRepository<EscalationStatusJpaEntity, UUID> {}
