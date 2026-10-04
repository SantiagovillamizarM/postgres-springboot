package com.tarea.domain.chatairunmetric.exception;

public class ChatAiRunMetricNotFoundException extends RuntimeException {
    public ChatAiRunMetricNotFoundException(String id) {
        super("Métrica de ejecución de IA no encontrada con el ID: " + id);
    }
}
