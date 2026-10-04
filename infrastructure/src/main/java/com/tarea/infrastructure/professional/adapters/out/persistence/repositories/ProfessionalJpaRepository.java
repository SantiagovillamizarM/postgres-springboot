package com.tarea.infrastructure.professional.adapters.out.persistence.repositories;

import com.tarea.infrastructure.professional.adapters.out.persistence.entity.ProfessionalJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfessionalJpaRepository extends JpaRepository<ProfessionalJpaEntity, UUID> {
    boolean existsByDocumentNumber(String documentNumber);
}
