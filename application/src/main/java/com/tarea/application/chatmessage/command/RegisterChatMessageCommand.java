package com.tarea.application.chatmessage.command;

import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;

public record RegisterChatMessageCommand(
        ChatConversationId conversationId,
        MessageTypeId messageTypeId,
        ChatParticipantId participantId,
        String content,
        String metadata
) {
}
