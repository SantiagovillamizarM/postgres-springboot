package com.tarea.domain.professional.exception;

public class ProfessionalNotFoundException extends RuntimeException {
    public ProfessionalNotFoundException(String id) {
        super("Profesional no encontrado con el ID: " + id);
    }
}
