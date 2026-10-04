package com.tarea.infrastructure.chatconversation.adapters.out.persistence.repositories;

import com.tarea.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatConversationJpaRepository extends JpaRepository<ChatConversationJpaEntity, UUID> {}
