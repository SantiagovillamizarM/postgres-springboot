package com.tarea.application.relationshiptype.usecase;

import com.tarea.application.relationshiptype.command.RegisterRelationshipTypeCommand;
import com.tarea.application.relationshiptype.dto.RelationshipTypeResponse;
import com.tarea.domain.relationshiptype.model.aggregate.RelationshipType;
import com.tarea.domain.relationshiptype.port.repository.RelationshipTypeRepository;

public class RegisterRelationshipTypeUseCase {

    private final RelationshipTypeRepository relationshipTypeRepository;

    public RegisterRelationshipTypeUseCase(RelationshipTypeRepository relationshipTypeRepository) {
        this.relationshipTypeRepository = relationshipTypeRepository;
    }

    public RelationshipTypeResponse execute(RegisterRelationshipTypeCommand command) {
        RelationshipType relationshipType = RelationshipType.register(
                command.description()
        );

        RelationshipType saved = relationshipTypeRepository.save(relationshipType);

        return new RelationshipTypeResponse(
            saved.id().value(),
            saved.description()
        );
    }
}
