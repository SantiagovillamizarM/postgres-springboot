package com.tarea.application.escalationstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EscalationStatusNotFoundApplicationException extends ApplicationException {

    public EscalationStatusNotFoundApplicationException(String id) {
        super("Estado de escalamiento no encontrado con el ID: " + id);
    }
}
