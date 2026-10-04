package com.tarea.application.documenttype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class DocumentTypeNotFoundApplicationException extends ApplicationException {

    public DocumentTypeNotFoundApplicationException(String id) {
        super("Tipo de documento no encontrado con el ID: " + id);
    }
}
