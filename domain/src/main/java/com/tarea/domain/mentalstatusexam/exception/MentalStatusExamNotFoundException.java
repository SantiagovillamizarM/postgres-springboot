package com.tarea.domain.mentalstatusexam.exception;

public class MentalStatusExamNotFoundException extends RuntimeException {
    public MentalStatusExamNotFoundException(String id) {
        super("Examen mental no encontrado con el ID: " + id);
    }
}
