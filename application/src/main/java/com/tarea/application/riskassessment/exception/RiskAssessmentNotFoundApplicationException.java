package com.tarea.application.riskassessment.exception;

import com.tarea.application.common.exception.ApplicationException;

public class RiskAssessmentNotFoundApplicationException extends ApplicationException {

    public RiskAssessmentNotFoundApplicationException(String id) {
        super("Evaluación de riesgo no encontrada con el ID: " + id);
    }
}
