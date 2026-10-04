package com.tarea.domain.stateregion.exception;

public class StateRegionNotFoundException extends RuntimeException {
    public StateRegionNotFoundException(String id) {
        super("Región no encontrada con el ID: " + id);
    }
}
