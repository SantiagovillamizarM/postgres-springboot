package com.tarea.domain.treatmentplan.exception;

public class TreatmentPlanNotFoundException extends RuntimeException {
    public TreatmentPlanNotFoundException(String id) {
        super("Plan de tratamiento no encontrado con el ID: " + id);
    }
}
