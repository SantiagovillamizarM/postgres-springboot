package com.tarea.infrastructure.messagetype.adapters.out.persistence.repositories;

import com.tarea.infrastructure.messagetype.adapters.out.persistence.entity.MessageTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MessageTypeJpaRepository extends JpaRepository<MessageTypeJpaEntity, UUID> {}
