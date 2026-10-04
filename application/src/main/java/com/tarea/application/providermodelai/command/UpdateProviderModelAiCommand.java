package com.tarea.application.providermodelai.command;

import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

public record UpdateProviderModelAiCommand(
        ProviderModelAiId id,
        String nameProviderAi,
        String razonSocial,
        String sitioWeb,
        Boolean active
) {
}
