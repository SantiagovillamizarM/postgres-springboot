package com.tarea.domain.priority.exception;

public class PriorityNotFoundException extends RuntimeException {
    public PriorityNotFoundException(String id) {
        super("Prioridad no encontrada con el ID: " + id);
    }
}
