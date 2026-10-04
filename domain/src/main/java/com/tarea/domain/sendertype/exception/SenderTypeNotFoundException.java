package com.tarea.domain.sendertype.exception;

public class SenderTypeNotFoundException extends RuntimeException {
    public SenderTypeNotFoundException(String id) {
        super("Tipo de remitente no encontrado con el ID: " + id);
    }
}
