package com.tarea.application.encounterstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EncounterStatusNotFoundApplicationException extends ApplicationException {

    public EncounterStatusNotFoundApplicationException(String id) {
        super("Estado de encuentro no encontrado con el ID: " + id);
    }
}
