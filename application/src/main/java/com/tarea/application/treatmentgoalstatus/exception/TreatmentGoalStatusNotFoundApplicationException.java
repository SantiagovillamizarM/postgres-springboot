package com.tarea.application.treatmentgoalstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class TreatmentGoalStatusNotFoundApplicationException extends ApplicationException {

    public TreatmentGoalStatusNotFoundApplicationException(String id) {
        super("Estado de meta de tratamiento no encontrado con el ID: " + id);
    }
}
