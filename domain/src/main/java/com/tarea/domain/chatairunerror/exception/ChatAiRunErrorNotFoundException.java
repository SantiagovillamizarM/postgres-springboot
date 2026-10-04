package com.tarea.domain.chatairunerror.exception;

public class ChatAiRunErrorNotFoundException extends RuntimeException {
    public ChatAiRunErrorNotFoundException(String id) {
        super("Error de ejecución de IA no encontrado con el ID: " + id);
    }
}
