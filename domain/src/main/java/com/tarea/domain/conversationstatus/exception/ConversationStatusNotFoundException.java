package com.tarea.domain.conversationstatus.exception;

public class ConversationStatusNotFoundException extends RuntimeException {
    public ConversationStatusNotFoundException(String id) {
        super("Estado de conversación no encontrado con el ID: " + id);
    }
}
