package com.tarea.infrastructure.chatairunmetric.adapters.in.rest.dtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateChatAiRunMetricRequest(
        @NotNull(message = "La ejecución de IA es obligatoria")
        UUID aiRunId,

        Integer promptTokens,

        Integer completionTokens,

        Integer totalTokens,

        BigDecimal cost
) {
}
