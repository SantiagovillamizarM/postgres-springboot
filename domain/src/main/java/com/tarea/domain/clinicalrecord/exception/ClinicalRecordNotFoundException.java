package com.tarea.domain.clinicalrecord.exception;

public class ClinicalRecordNotFoundException extends RuntimeException {
    public ClinicalRecordNotFoundException(String id) {
        super("Historia clínica no encontrada con el ID: " + id);
    }
}
