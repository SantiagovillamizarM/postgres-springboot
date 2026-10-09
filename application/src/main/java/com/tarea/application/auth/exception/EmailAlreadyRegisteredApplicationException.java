package com.tarea.application.auth.exception;

import com.tarea.application.common.exception.ApplicationException;

public class EmailAlreadyRegisteredApplicationException extends ApplicationException {

    public EmailAlreadyRegisteredApplicationException(String email) {
        super("Ya existe un usuario con el email: " + email);
    }
}
