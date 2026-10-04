package com.tarea.application.professionaltype.command;

import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

public record UpdateProfessionalTypeCommand(
        ProfessionalTypeId id,
        String name
) {
}
