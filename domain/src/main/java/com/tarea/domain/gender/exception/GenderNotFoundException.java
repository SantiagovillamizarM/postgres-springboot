package com.tarea.domain.gender.exception;

public class GenderNotFoundException extends RuntimeException {
    public GenderNotFoundException(String id) {
        super("Género no encontrado con el ID: " + id);
    }
}
