package com.tarea.application.emailcontact.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EmailContactNotFoundApplicationException extends ApplicationException {

    public EmailContactNotFoundApplicationException(String id) {
        super("Correo de contacto no encontrado con el ID: " + id);
    }
}
