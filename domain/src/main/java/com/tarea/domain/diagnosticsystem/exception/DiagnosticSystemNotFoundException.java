package com.tarea.domain.diagnosticsystem.exception;

public class DiagnosticSystemNotFoundException extends RuntimeException {
    public DiagnosticSystemNotFoundException(String id) {
        super("Sistema diagnóstico no encontrado con el ID: " + id);
    }
}
