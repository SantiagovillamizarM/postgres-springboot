package com.tarea.infrastructure.chatmessage.adapters.out.persistence.repositories;

import com.tarea.infrastructure.chatmessage.adapters.out.persistence.entity.ChatMessageJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatMessageJpaRepository extends JpaRepository<ChatMessageJpaEntity, UUID> {}
