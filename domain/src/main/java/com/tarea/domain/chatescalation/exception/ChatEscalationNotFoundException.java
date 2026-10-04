package com.tarea.domain.chatescalation.exception;

public class ChatEscalationNotFoundException extends RuntimeException {
    public ChatEscalationNotFoundException(String id) {
        super("Escalamiento no encontrado con el ID: " + id);
    }
}
