package com.tarea.application.relationshiptype.usecase;

import com.tarea.application.relationshiptype.dto.RelationshipTypeResponse;
import com.tarea.domain.relationshiptype.port.repository.RelationshipTypeRepository;

import java.util.List;

public class ListRelationshipTypeUseCase {

    private final RelationshipTypeRepository relationshipTypeRepository;

    public ListRelationshipTypeUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        this.relationshipTypeRepository = relationshipTypeRepository;
    }

    public List<RelationshipTypeResponse> execute() {
        return relationshipTypeRepository.findAll().stream()
                .map(relationshipType -> new RelationshipTypeResponse(
                    relationshipType.id().value(),
                    relationshipType.description()
                ))
                .toList();
    }
}
