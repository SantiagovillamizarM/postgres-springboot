package com.tarea.domain.clinicalrecordstatus.exception;

public class ClinicalRecordStatusNotFoundException extends RuntimeException {
    public ClinicalRecordStatusNotFoundException(String id) {
        super("Estado de historia clínica no encontrado con el ID: " + id);
    }
}
