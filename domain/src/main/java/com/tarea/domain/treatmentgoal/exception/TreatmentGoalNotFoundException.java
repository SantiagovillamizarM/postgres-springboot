package com.tarea.domain.treatmentgoal.exception;

public class TreatmentGoalNotFoundException extends RuntimeException {
    public TreatmentGoalNotFoundException(String id) {
        super("Meta de tratamiento no encontrada con el ID: " + id);
    }
}
