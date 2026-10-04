package com.tarea.application.phonecontact.exception;

import com.tarea.application.common.exception.ApplicationException;

public class PhoneContactNotFoundApplicationException extends ApplicationException {

    public PhoneContactNotFoundApplicationException(String id) {
        super("Teléfono de contacto no encontrado con el ID: " + id);
    }
}
