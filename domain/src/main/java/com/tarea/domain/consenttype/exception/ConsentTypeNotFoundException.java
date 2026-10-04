package com.tarea.domain.consenttype.exception;

public class ConsentTypeNotFoundException extends RuntimeException {
    public ConsentTypeNotFoundException(String id) {
        super("Tipo de consentimiento no encontrado con el ID: " + id);
    }
}
