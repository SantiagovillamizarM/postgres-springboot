package com.tarea.domain.phonecontact.exception;

public class PhoneContactNotFoundException extends RuntimeException {
    public PhoneContactNotFoundException(String id) {
        super("Teléfono de contacto no encontrado con el ID: " + id);
    }
}
