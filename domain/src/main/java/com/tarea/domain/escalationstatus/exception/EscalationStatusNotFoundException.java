package com.tarea.domain.escalationstatus.exception;

public class EscalationStatusNotFoundException extends RuntimeException {
    public EscalationStatusNotFoundException(String id) {
        super("Estado de escalamiento no encontrado con el ID: " + id);
    }
}
