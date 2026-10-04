package com.tarea.application.clinicalrecord.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ClinicalRecordNotFoundApplicationException extends ApplicationException {

    public ClinicalRecordNotFoundApplicationException(String id) {
        super("Historia clínica no encontrada con el ID: " + id);
    }
}
