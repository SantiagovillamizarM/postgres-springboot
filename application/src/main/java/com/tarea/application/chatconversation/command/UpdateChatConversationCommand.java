package com.tarea.application.chatconversation.command;

import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.priority.model.valueobject.PriorityId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;

import java.time.LocalDateTime;

public record UpdateChatConversationCommand(
        ChatConversationId id,
        ConversationStatusId conversationStatusId,
        PriorityId priorityId,
        LocalDateTime lastMessageAt,
        Boolean closed,
        LocalDateTime closedAt,
        ProfessionalId closedBy
) {
}
