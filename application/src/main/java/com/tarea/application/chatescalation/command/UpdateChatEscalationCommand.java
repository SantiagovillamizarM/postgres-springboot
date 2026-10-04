package com.tarea.application.chatescalation.command;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;

public record UpdateChatEscalationCommand(
        ChatEscalationId id,
        ChatConversationId conversationId,
        EscalationStatusId statusId,
        Boolean fromAi,
        String reason
) {
}
