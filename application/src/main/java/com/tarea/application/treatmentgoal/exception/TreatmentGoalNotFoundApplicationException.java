package com.tarea.application.treatmentgoal.exception;

import com.tarea.application.common.exception.ApplicationException;

public class TreatmentGoalNotFoundApplicationException extends ApplicationException {

    public TreatmentGoalNotFoundApplicationException(String id) {
        super("Meta de tratamiento no encontrada con el ID: " + id);
    }
}
