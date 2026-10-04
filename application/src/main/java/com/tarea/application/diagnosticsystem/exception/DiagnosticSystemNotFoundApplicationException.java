package com.tarea.application.diagnosticsystem.exception;

import com.tarea.application.common.exception.ApplicationException;

public class DiagnosticSystemNotFoundApplicationException extends ApplicationException {

    public DiagnosticSystemNotFoundApplicationException(String id) {
        super("Sistema diagnóstico no encontrado con el ID: " + id);
    }
}
