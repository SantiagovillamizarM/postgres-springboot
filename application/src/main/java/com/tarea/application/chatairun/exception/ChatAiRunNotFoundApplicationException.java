package com.tarea.application.chatairun.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatAiRunNotFoundApplicationException extends ApplicationException {

    public ChatAiRunNotFoundApplicationException(String id) {
        super("Ejecución de IA no encontrada con el ID: " + id);
    }
}
