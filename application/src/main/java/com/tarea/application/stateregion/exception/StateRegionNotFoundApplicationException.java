package com.tarea.application.stateregion.exception;

import com.tarea.application.common.exception.ApplicationException;

public class StateRegionNotFoundApplicationException extends ApplicationException {

    public StateRegionNotFoundApplicationException(String id) {
        super("Región no encontrada con el ID: " + id);
    }
}
