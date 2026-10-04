package com.tarea.domain.study.exception;

public class StudyNotFoundException extends RuntimeException {
    public StudyNotFoundException(String id) {
        super("Estudio no encontrado con el ID: " + id);
    }
}
