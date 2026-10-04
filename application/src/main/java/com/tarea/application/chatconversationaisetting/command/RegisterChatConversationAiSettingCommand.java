package com.tarea.application.chatconversationaisetting.command;

import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;

public record RegisterChatConversationAiSettingCommand(
        ChatConversationId conversationId,
        Boolean aiEnabled,
        AiModelId defaultModelId
) {
}
