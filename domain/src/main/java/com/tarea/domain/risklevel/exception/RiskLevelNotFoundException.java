package com.tarea.domain.risklevel.exception;

public class RiskLevelNotFoundException extends RuntimeException {
    public RiskLevelNotFoundException(String id) {
        super("Nivel de riesgo no encontrado con el ID: " + id);
    }
}
