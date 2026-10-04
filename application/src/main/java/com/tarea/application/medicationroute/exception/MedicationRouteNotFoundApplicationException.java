package com.tarea.application.medicationroute.exception;

import com.tarea.application.common.exception.ApplicationException;

public class MedicationRouteNotFoundApplicationException extends ApplicationException {

    public MedicationRouteNotFoundApplicationException(String id) {
        super("Vía de administración no encontrada con el ID: " + id);
    }
}
