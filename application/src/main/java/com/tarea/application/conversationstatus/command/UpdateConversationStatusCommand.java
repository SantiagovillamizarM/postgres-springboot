package com.tarea.application.conversationstatus.command;

import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;

public record UpdateConversationStatusCommand(
        ConversationStatusId id,
        String nameStatus
) {
}
