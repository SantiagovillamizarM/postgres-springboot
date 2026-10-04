package com.tarea.domain.providermodelai.exception;

public class ProviderModelAiNotFoundException extends RuntimeException {
    public ProviderModelAiNotFoundException(String id) {
        super("Proveedor de IA no encontrado con el ID: " + id);
    }
}
