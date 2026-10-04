package com.tarea.domain.chatescalationstatushistory.exception;

public class ChatEscalationStatusHistoryNotFoundException extends RuntimeException {
    public ChatEscalationStatusHistoryNotFoundException(String id) {
        super("Historial de estado de escalamiento no encontrado con el ID: " + id);
    }
}
