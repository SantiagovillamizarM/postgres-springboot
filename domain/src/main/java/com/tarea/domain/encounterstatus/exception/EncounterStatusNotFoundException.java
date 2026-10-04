package com.tarea.domain.encounterstatus.exception;

public class EncounterStatusNotFoundException extends RuntimeException {
    public EncounterStatusNotFoundException(String id) {
        super("Estado de encuentro no encontrado con el ID: " + id);
    }
}
