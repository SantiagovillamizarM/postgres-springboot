package com.tarea.domain.relationshiptype.port.repository;

import com.tarea.domain.relationshiptype.model.aggregate.RelationshipType;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;

import java.util.List;
import java.util.Optional;

public interface RelationshipTypeRepository {
    RelationshipType save(RelationshipType relationshipType);
    Optional<RelationshipType> findById(RelationshipTypeId id);
    List<RelationshipType> findAll();
    boolean existsByDescription(String description);
    void delete(RelationshipType relationshipType);
}
