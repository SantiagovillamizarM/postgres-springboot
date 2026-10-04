package com.tarea.domain.encounter.exception;

public class EncounterNotFoundException extends RuntimeException {
    public EncounterNotFoundException(String id) {
        super("Encuentro no encontrado con el ID: " + id);
    }
}
