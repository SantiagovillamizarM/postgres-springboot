package com.tarea.application.chatairunmetric.command;

import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

import java.math.BigDecimal;

public record UpdateChatAiRunMetricCommand(
        ChatAiRunMetricId id,
        ChatAiRunId aiRunId,
        Integer promptTokens,
        Integer completionTokens,
        Integer totalTokens,
        BigDecimal cost
) {
}
