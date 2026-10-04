package com.tarea.application.chatairunerror.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatAiRunErrorNotFoundApplicationException extends ApplicationException {

    public ChatAiRunErrorNotFoundApplicationException(String id) {
        super("Error de ejecución de IA no encontrado con el ID: " + id);
    }
}
