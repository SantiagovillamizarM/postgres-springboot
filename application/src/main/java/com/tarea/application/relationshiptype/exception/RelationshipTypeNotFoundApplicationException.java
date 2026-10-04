package com.tarea.application.relationshiptype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class RelationshipTypeNotFoundApplicationException extends ApplicationException {

    public RelationshipTypeNotFoundApplicationException(String id) {
        super("Tipo de relación no encontrado con el ID: " + id);
    }
}
