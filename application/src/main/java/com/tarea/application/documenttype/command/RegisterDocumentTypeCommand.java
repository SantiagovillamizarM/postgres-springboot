package com.tarea.application.documenttype.command;

public record RegisterDocumentTypeCommand(
        String code,
        String name,
        Boolean active
) {
}
