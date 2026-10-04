package com.tarea.infrastructure.contact.adapters.out.persistence.repositories;

import com.tarea.infrastructure.contact.adapters.out.persistence.entity.ContactJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ContactJpaRepository extends JpaRepository<ContactJpaEntity, UUID> {}
