package com.tarea.application.professionalstudy.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ProfessionalStudyNotFoundApplicationException extends ApplicationException {

    public ProfessionalStudyNotFoundApplicationException(String id) {
        super("Estudio del profesional no encontrado con el ID: " + id);
    }
}
