package com.tarea.application.airunstatus.command;

import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;

public record UpdateAiRunStatusCommand(
        AiRunStatusId id,
        String nameStatus
) {
}
