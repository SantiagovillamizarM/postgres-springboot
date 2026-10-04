package com.tarea.application.chatescalationstatushistory.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ChatEscalationStatusHistoryNotFoundApplicationException extends ApplicationException {

    public ChatEscalationStatusHistoryNotFoundApplicationException(String id) {
        super("Historial de estado de escalamiento no encontrado con el ID: " + id);
    }
}
