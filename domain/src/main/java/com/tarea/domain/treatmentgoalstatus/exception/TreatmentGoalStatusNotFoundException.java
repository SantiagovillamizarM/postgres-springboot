package com.tarea.domain.treatmentgoalstatus.exception;

public class TreatmentGoalStatusNotFoundException extends RuntimeException {
    public TreatmentGoalStatusNotFoundException(String id) {
        super("Estado de meta de tratamiento no encontrado con el ID: " + id);
    }
}
