package com.tarea.infrastructure.chatescalation.adapters.out.persistence.repositories;

import com.tarea.infrastructure.chatescalation.adapters.out.persistence.entity.ChatEscalationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatEscalationJpaRepository extends JpaRepository<ChatEscalationJpaEntity, UUID> {}
