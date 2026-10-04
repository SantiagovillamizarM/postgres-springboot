package com.tarea.domain.relationshiptype.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record RelationshipTypeId(UUID value) {
    public RelationshipTypeId {
        Objects.requireNonNull(value, "El valor de RelationshipTypeId no puede ser nulo");
    }

    public static RelationshipTypeId generate() {
        return new RelationshipTypeId(UUID.randomUUID());
    }
}
