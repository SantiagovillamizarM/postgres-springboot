package com.tarea.application.encountermodality.command;

import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;

public record UpdateEncounterModalityCommand(
        EncounterModalityId id,
        String code,
        String name,
        Boolean active
) {
}
