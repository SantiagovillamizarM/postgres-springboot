package com.tarea.infrastructure.sendertype.adapters.out.persistence.repositories;

import com.tarea.infrastructure.sendertype.adapters.out.persistence.entity.SenderTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SenderTypeJpaRepository extends JpaRepository<SenderTypeJpaEntity, UUID> {}
