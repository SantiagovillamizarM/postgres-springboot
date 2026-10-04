package com.tarea.domain.emailcontact.exception;

public class EmailContactNotFoundException extends RuntimeException {
    public EmailContactNotFoundException(String id) {
        super("Correo de contacto no encontrado con el ID: " + id);
    }
}
