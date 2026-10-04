package com.tarea.application.patientcontact.exception;

import com.tarea.application.common.exception.ApplicationException;

public class PatientContactNotFoundApplicationException extends ApplicationException {

    public PatientContactNotFoundApplicationException(String id) {
        super("Contacto del paciente no encontrado con el ID: " + id);
    }
}
