package com.tarea.application.relationshiptype.command;

import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;

public record UpdateRelationshipTypeCommand(
        RelationshipTypeId id,
        String description
) {
}
