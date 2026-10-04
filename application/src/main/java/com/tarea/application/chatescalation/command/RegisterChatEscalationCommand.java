package com.tarea.application.chatescalation.command;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;

public record RegisterChatEscalationCommand(
        ChatConversationId conversationId,
        EscalationStatusId statusId,
        Boolean fromAi,
        String reason
) {
}
