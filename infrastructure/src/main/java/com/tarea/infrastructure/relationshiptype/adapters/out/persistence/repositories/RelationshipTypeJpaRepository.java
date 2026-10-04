package com.tarea.infrastructure.relationshiptype.adapters.out.persistence.repositories;

import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.entity.RelationshipTypeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RelationshipTypeJpaRepository extends JpaRepository<RelationshipTypeJpaEntity, UUID> {
    boolean existsByDescription(String description);
}
