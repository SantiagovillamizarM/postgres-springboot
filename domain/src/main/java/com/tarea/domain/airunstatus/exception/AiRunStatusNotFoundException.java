package com.tarea.domain.airunstatus.exception;

public class AiRunStatusNotFoundException extends RuntimeException {
    public AiRunStatusNotFoundException(String id) {
        super("Estado de ejecución de IA no encontrado con el ID: " + id);
    }
}
