package com.tarea.infrastructure.chatairun.adapters.out.persistence.repositories;

import com.tarea.infrastructure.chatairun.adapters.out.persistence.entity.ChatAiRunJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatAiRunJpaRepository extends JpaRepository<ChatAiRunJpaEntity, UUID> {}
