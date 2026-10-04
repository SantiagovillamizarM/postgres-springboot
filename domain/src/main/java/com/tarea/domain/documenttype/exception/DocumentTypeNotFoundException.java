package com.tarea.domain.documenttype.exception;

public class DocumentTypeNotFoundException extends RuntimeException {
    public DocumentTypeNotFoundException(String id) {
        super("Tipo de documento no encontrado con el ID: " + id);
    }
}
