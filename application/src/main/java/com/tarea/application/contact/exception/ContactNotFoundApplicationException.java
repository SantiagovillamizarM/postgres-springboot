package com.tarea.application.contact.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ContactNotFoundApplicationException extends ApplicationException {

    public ContactNotFoundApplicationException(String id) {
        super("Contacto no encontrado con el ID: " + id);
    }
}
