package com.tarea.application.chatairunmetric.command;

import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;

import java.math.BigDecimal;

public record RegisterChatAiRunMetricCommand(
        ChatAiRunId aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        BigDecimal cost
) {
}
