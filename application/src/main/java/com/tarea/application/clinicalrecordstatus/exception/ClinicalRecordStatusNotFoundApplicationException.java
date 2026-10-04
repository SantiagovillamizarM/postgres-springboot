package com.tarea.application.clinicalrecordstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ClinicalRecordStatusNotFoundApplicationException extends ApplicationException {

    public ClinicalRecordStatusNotFoundApplicationException(String id) {
        super("Estado de historia clínica no encontrado con el ID: " + id);
    }
}
