package com.tarea.domain.relationshiptype.exception;

public class RelationshipTypeNotFoundException extends RuntimeException {
    public RelationshipTypeNotFoundException(String id) {
        super("Tipo de relación no encontrado con el ID: " + id);
    }
}
