package com.tarea.application.relationshiptype.usecase;

import com.tarea.application.relationshiptype.exception.RelationshipTypeNotFoundApplicationException;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.tarea.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class DeleteRelationshipTypeUseCase {

    private final RelationshipTypeRepository relationshipTypeRepository;

    public DeleteRelationshipTypeUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        this.relationshipTypeRepository = relationshipTypeRepository;
    }

    public void execute(RelationshipTypeId id) {
        var relationshipType = relationshipTypeRepository.findById(id)
                .orElseThrow(() -> new RelationshipTypeNotFoundApplicationException(id.value().toString()));

        relationshipType.markAsDeleted();
        relationshipTypeRepository.delete(relationshipType);
    }
}
