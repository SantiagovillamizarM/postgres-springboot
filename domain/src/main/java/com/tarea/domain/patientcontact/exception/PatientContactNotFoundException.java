package com.tarea.domain.patientcontact.exception;

public class PatientContactNotFoundException extends RuntimeException {
    public PatientContactNotFoundException(String id) {
        super("Contacto del paciente no encontrado con el ID: " + id);
    }
}
