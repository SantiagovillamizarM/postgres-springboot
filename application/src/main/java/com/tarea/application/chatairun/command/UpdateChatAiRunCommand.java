package com.tarea.application.chatairun.command;

import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;

public record UpdateChatAiRunCommand(
        ChatAiRunId id,
        ChatConversationId conversationId,
        ChatMessageId messageId,
        AiModelId modelId,
        AiRunStatusId aiRunStatusId
) {
}
