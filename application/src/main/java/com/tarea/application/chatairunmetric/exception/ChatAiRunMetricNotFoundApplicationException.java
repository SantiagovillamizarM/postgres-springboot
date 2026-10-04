package com.tarea.application.chatairunmetric.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatAiRunMetricNotFoundApplicationException extends ApplicationException {

    public ChatAiRunMetricNotFoundApplicationException(String id) {
        super("Métrica de ejecución de IA no encontrada con el ID: " + id);
    }
}
