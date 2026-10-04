package com.tarea.domain.treatmentstatus.exception;

public class TreatmentStatusNotFoundException extends RuntimeException {
    public TreatmentStatusNotFoundException(String id) {
        super("Estado de tratamiento no encontrado con el ID: " + id);
    }
}
