package com.tarea.application.chatconversationaisetting.command;

import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversationaisetting.model.valueobject.ChatConversationAiSettingId;

public record UpdateChatConversationAiSettingCommand(
        ChatConversationAiSettingId id,
        ChatConversationId conversationId,
        Boolean aiEnabled,
        AiModelId defaultModelId
) {
}
