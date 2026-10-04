package com.tarea.application.aimodel.exception;

import com.tarea.application.common.exception.ApplicationException;

public class AiModelNotFoundApplicationException extends ApplicationException {

    public AiModelNotFoundApplicationException(String id) {
        super("Modelo de IA no encontrado con el ID: " + id);
    }
}
