package com.tarea.domain.professionaltype.exception;

public class ProfessionalTypeNotFoundException extends RuntimeException {
    public ProfessionalTypeNotFoundException(String id) {
        super("Tipo de profesional no encontrado con el ID: " + id);
    }
}
