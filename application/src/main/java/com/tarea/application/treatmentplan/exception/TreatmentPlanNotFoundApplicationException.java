package com.tarea.application.treatmentplan.exception;

import com.tarea.application.common.exception.ApplicationException;

public class TreatmentPlanNotFoundApplicationException extends ApplicationException {

    public TreatmentPlanNotFoundApplicationException(String id) {
        super("Plan de tratamiento no encontrado con el ID: " + id);
    }
}
