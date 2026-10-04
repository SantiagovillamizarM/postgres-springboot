package com.tarea.domain.chatairun.exception;

public class ChatAiRunNotFoundException extends RuntimeException {
    public ChatAiRunNotFoundException(String id) {
        super("Ejecución de IA no encontrada con el ID: " + id);
    }
}
