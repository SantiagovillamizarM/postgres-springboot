package com.tarea.application.chatairunerror.command;

import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;

public record RegisterChatAiRunErrorCommand(
        ChatAiRunId aiRunId,
        String errorMessage,
        String errorCode,
        String providerErrorId
) {
}
