package com.tarea.application.chatairunerror.command;

import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;

public record UpdateChatAiRunErrorCommand(
        ChatAiRunErrorId id,
        ChatAiRunId aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId
) {
}
