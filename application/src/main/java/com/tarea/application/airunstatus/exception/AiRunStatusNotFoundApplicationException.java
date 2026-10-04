package com.tarea.application.airunstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class AiRunStatusNotFoundApplicationException extends ApplicationException {

    public AiRunStatusNotFoundApplicationException(String id) {
        super("Estado de ejecución de IA no encontrado con el ID: " + id);
    }
}
