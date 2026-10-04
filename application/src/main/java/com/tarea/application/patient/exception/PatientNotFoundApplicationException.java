package com.tarea.application.patient.exception;

import com.tarea.application.common.exception.ApplicationException;

public class PatientNotFoundApplicationException extends ApplicationException {

    public PatientNotFoundApplicationException(String id) {
        super("Paciente no encontrado con el ID: " + id);
    }
}
