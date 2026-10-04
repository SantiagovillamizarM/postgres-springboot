package com.tarea.application.chatescalation.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatEscalationNotFoundApplicationException extends ApplicationException {

    public ChatEscalationNotFoundApplicationException(String id) {
        super("Escalamiento no encontrado con el ID: " + id);
    }
}
