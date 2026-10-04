package com.tarea.application.assessmenttype.exception;

import com.tarea.application.common.exception.ApplicationException;

public class AssessmentTypeNotFoundApplicationException extends ApplicationException {

    public AssessmentTypeNotFoundApplicationException(String id) {
        super("Tipo de evaluación no encontrado con el ID: " + id);
    }
}
