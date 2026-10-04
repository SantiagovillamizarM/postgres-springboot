package com.tarea.application.relationshiptype.dto;

import java.util.UUID;

public record RelationshipTypeResponse(
        UUID id,
        String description
) {
}
