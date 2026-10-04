package com.tarea.domain.clinicalnote.exception;

public class ClinicalNoteNotFoundException extends RuntimeException {
    public ClinicalNoteNotFoundException(String id) {
        super("Nota clínica no encontrada con el ID: " + id);
    }
}
