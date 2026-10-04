package com.tarea.domain.aimodel.exception;

public class AiModelNotFoundException extends RuntimeException {
    public AiModelNotFoundException(String id) {
        super("Modelo de IA no encontrado con el ID: " + id);
    }
}
