package com.tarea.application.auth.exception;

import com.tarea.application.common.exception.ApplicationException;

// Mismo mensaje si el email no existe o si la contraseña está mal, para no revelar qué emails están registrados
public class InvalidCredentialsApplicationException extends ApplicationException {

    public InvalidCredentialsApplicationException() {
        super("Credenciales inválidas");
    }
}
