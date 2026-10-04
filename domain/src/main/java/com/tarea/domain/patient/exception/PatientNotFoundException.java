package com.tarea.domain.patient.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String id) {
        super("Paciente no encontrado con el ID: " + id);
    }
}
