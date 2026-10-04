package com.tarea.domain.medicationroute.exception;

public class MedicationRouteNotFoundException extends RuntimeException {
    public MedicationRouteNotFoundException(String id) {
        super("Vía de administración no encontrada con el ID: " + id);
    }
}
