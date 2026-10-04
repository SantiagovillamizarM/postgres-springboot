package com.tarea.domain.encountertype.exception;

public class EncounterTypeNotFoundException extends RuntimeException {
    public EncounterTypeNotFoundException(String id) {
        super("Tipo de encuentro no encontrado con el ID: " + id);
    }
}
