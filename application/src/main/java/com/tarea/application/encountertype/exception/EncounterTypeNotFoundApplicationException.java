package com.tarea.application.encountertype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EncounterTypeNotFoundApplicationException extends ApplicationException {

    public EncounterTypeNotFoundApplicationException(String id) {
        super("Tipo de encuentro no encontrado con el ID: " + id);
    }
}
