package com.tarea.application.aimodel.command;

import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;

import java.math.BigDecimal;

public record RegisterAiModelCommand(
        ProviderModelAiId providerModelId,
        String nameModel,
        String modelKey,
        BigDecimal inputTokenPrice,
        BigDecimal outputTokenPrice,
        Integer maxTokens,
        Integer contextWindow,
        Boolean active
) {
}
