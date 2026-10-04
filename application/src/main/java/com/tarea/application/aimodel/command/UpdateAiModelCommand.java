package com.tarea.application.aimodel.command;

import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;

import java.math.BigDecimal;

public record UpdateAiModelCommand(
        AiModelId id,
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
