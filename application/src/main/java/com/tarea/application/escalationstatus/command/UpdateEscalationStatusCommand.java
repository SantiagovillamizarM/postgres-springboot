package com.tarea.application.escalationstatus.command;

import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

public record UpdateEscalationStatusCommand(
        EscalationStatusId id,
        String nameStatus
) {
}
