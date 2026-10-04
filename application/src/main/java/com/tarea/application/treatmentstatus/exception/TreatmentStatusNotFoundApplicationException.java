package com.tarea.application.treatmentstatus.exception;

import com.tarea.application.common.exception.ApplicationException;

public class TreatmentStatusNotFoundApplicationException extends ApplicationException {

    public TreatmentStatusNotFoundApplicationException(String id) {
        super("Estado de tratamiento no encontrado con el ID: " + id);
    }
}
