package com.tarea.domain.encountermodality.exception;

public class EncounterModalityNotFoundException extends RuntimeException {
    public EncounterModalityNotFoundException(String id) {
        super("Modalidad de encuentro no encontrada con el ID: " + id);
    }
}
