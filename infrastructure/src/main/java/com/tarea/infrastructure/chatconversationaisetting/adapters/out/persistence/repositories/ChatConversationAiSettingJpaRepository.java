package com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.repositories;

import com.tarea.infrastructure.chatconversationaisetting.adapters.out.persistence.entity.ChatConversationAiSettingJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatConversationAiSettingJpaRepository extends JpaRepository<ChatConversationAiSettingJpaEntity, UUID> {}
