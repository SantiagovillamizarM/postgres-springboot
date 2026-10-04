package com.tarea.application.risklevel.exception;

import com.tarea.application.common.exception.ApplicationException;

public class RiskLevelNotFoundApplicationException extends ApplicationException {

    public RiskLevelNotFoundApplicationException(String id) {
        super("Nivel de riesgo no encontrado con el ID: " + id);
    }
}
