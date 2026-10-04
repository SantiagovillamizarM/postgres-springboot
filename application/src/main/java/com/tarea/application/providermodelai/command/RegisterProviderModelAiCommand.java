package com.tarea.application.providermodelai.command;

public record RegisterProviderModelAiCommand(
        String nameProviderAi,
        String razonSocial,
        String sitioWeb,
        Boolean active
) {
}
