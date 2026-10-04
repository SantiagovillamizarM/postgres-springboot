package com.tarea.domain.messagetype.exception;

public class MessageTypeNotFoundException extends RuntimeException {
    public MessageTypeNotFoundException(String id) {
        super("Tipo de mensaje no encontrado con el ID: " + id);
    }
}
