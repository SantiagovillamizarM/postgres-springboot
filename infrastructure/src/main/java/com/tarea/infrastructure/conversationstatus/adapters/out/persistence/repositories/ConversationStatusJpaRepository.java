package com.tarea.infrastructure.conversationstatus.adapters.out.persistence.repositories;

import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.entity.ConversationStatusJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ConversationStatusJpaRepository extends JpaRepository<ConversationStatusJpaEntity, UUID> {}
