package com.tarea.application.consenttype.command;

import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;

public record UpdateConsentTypeCommand(
        ConsentTypeId id,
        String code,
        String name,
        Boolean active,
        String description
) {
}
