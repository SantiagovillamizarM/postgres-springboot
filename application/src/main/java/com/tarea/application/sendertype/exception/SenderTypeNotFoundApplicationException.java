package com.tarea.application.sendertype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class SenderTypeNotFoundApplicationException extends ApplicationException {

    public SenderTypeNotFoundApplicationException(String id) {
        super("Tipo de remitente no encontrado con el ID: " + id);
    }
}
