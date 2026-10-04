package com.tarea.infrastructure.emailcontact.adapters.out.persistence.repositories;

import com.tarea.infrastructure.emailcontact.adapters.out.persistence.entity.EmailContactJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailContactJpaRepository extends JpaRepository<EmailContactJpaEntity, UUID> {
    boolean existsByEmail(String email);
}
