package com.tarea.infrastructure.chatparticipant.adapters.out.persistence.repositories;

import com.tarea.infrastructure.chatparticipant.adapters.out.persistence.entity.ChatParticipantJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChatParticipantJpaRepository extends JpaRepository<ChatParticipantJpaEntity, UUID> {}
