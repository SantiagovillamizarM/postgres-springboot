package com.tarea.domain.professionalstudy.exception;

public class ProfessionalStudyNotFoundException extends RuntimeException {
    public ProfessionalStudyNotFoundException(String id) {
        super("Estudio del profesional no encontrado con el ID: " + id);
    }
}
