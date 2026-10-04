package com.tarea.infrastructure.gender.adapters.out.persistence.repositories;

import com.tarea.infrastructure.gender.adapters.out.persistence.entity.GenderJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GenderJpaRepository extends JpaRepository<GenderJpaEntity, UUID> {
    boolean existsByDescription(String description);
}
