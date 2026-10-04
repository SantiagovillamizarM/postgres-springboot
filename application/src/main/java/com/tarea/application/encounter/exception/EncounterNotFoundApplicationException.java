package com.tarea.application.encounter.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EncounterNotFoundApplicationException extends ApplicationException {

    public EncounterNotFoundApplicationException(String id) {
        super("Encuentro no encontrado con el ID: " + id);
    }
}
