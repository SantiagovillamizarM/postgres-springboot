package com.tarea.domain.patientallergy.exception;

public class PatientAllergyNotFoundException extends RuntimeException {
    public PatientAllergyNotFoundException(String id) {
        super("Alergia del paciente no encontrada con el ID: " + id);
    }
}
