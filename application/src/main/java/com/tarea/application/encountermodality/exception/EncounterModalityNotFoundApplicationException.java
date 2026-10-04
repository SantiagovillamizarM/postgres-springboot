package com.tarea.application.encountermodality.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EncounterModalityNotFoundApplicationException extends ApplicationException {

    public EncounterModalityNotFoundApplicationException(String id) {
        super("Modalidad de encuentro no encontrada con el ID: " + id);
    }
}
