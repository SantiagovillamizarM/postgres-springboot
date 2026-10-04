package com.tarea.domain.contact.exception;

public class ContactNotFoundException extends RuntimeException {
    public ContactNotFoundException(String id) {
        super("Contacto no encontrado con el ID: " + id);
    }
}
