package com.tarea.application.priority.command;

import com.tarea.domain.priority.model.valueobject.PriorityId;

public record UpdatePriorityCommand(
        PriorityId id,
        String namePriority
) {
}
