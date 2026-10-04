package com.tarea.domain.riskassessment.exception;

public class RiskAssessmentNotFoundException extends RuntimeException {
    public RiskAssessmentNotFoundException(String id) {
        super("Evaluación de riesgo no encontrada con el ID: " + id);
    }
}
