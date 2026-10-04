package com.tarea.domain.chatescalationassignment.exception;

public class ChatEscalationAssignmentNotFoundException extends RuntimeException {
    public ChatEscalationAssignmentNotFoundException(String id) {
        super("Asignación de escalamiento no encontrada con el ID: " + id);
    }
}
