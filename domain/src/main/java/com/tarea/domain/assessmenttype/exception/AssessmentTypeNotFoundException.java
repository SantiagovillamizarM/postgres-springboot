package com.tarea.domain.assessmenttype.exception;

public class AssessmentTypeNotFoundException extends RuntimeException {
    public AssessmentTypeNotFoundException(String id) {
        super("Tipo de evaluación no encontrado con el ID: " + id);
    }
}
