package com.tarea.application.auth.exception;

import com.tarea.application.common.exception.ApplicationException;

public class UserNotFoundApplicationException extends ApplicationException {

    public UserNotFoundApplicationException(String id) {
        super("Usuario no encontrado con el ID: " + id);
    }
}
