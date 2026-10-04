package com.tarea.application.clinicalnote.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ClinicalNoteNotFoundApplicationException extends ApplicationException {

    public ClinicalNoteNotFoundApplicationException(String id) {
        super("Nota clínica no encontrada con el ID: " + id);
    }
}
