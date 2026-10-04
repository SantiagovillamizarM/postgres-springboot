package com.tarea.application.providermodelai.exception;

import com.tarea.application.common.exception.ApplicationException;

public class ProviderModelAiNotFoundApplicationException extends ApplicationException {

    public ProviderModelAiNotFoundApplicationException(String id) {
        super("Proveedor de IA no encontrado con el ID: " + id);
    }
}
