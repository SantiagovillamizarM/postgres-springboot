package com.tarea.application.auth.exception;

import com.tarea.application.common.exception.ApplicationException;

public class InvalidRefreshTokenApplicationException extends ApplicationException {

    public InvalidRefreshTokenApplicationException() {
        super("Refresh token inválido, vencido o revocado");
    }
}
