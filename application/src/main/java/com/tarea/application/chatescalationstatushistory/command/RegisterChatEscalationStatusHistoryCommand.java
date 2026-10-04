package com.tarea.application.chatescalationstatushistory.command;

import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

import java.time.LocalDateTime;

public record RegisterChatEscalationStatusHistoryCommand(
        ChatEscalationId escalationId,
        EscalationStatusId escalationStatusId,
        LocalDateTime changedAt
) {
}
