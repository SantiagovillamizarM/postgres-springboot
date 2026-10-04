package com.tarea.application.chatescalationassignment.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatEscalationAssignmentNotFoundApplicationException extends ApplicationException {

    public ChatEscalationAssignmentNotFoundApplicationException(String id) {
        super("Asignación de escalamiento no encontrada con el ID: " + id);
    }
}
