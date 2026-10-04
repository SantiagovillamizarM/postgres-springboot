package com.tarea.application.documenttype.command;

import com.tarea.domain.documenttype.model.valueobject.DocumentTypeId;

public record UpdateDocumentTypeCommand(
        DocumentTypeId id,
        String code,
        String name,
        Boolean active
) {
}
