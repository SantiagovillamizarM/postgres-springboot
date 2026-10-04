package com.tarea.application.chatescalationstatushistory.command;

import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;

import java.time.LocalDateTime;

public record UpdateChatEscalationStatusHistoryCommand(
        ChatEscalationStatusHistoryId id,
        ChatEscalationId escalationId,
        EscalationStatusId escalationStatusId,
        LocalDateTime changedAt
) {
}
