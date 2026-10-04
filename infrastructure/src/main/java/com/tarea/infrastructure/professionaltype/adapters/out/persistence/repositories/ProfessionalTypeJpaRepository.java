package com.tarea.infrastructure.professionaltype.adapters.out.persistence.repositories;

import com.tarea.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessionalTypeJpaRepository extends JpaRepository<ProfessionalTypeJpaEntity, UUID> {
    boolean existsByName(String name);
}
