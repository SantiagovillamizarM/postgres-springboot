//Este es el lugar en donde esta alamacenado este archivo .java
package com.tarea.application.aimodel.usecase;

import com.tarea.application.aimodel.dto.AiModelResponse;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;

import java.util.List;

public class ListAiModelUseCase {

    private final AiModelRepository aiModelRepository;

    public ListAiModelUseCase(AiModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    public List<AiModelResponse> execute() {
        return aiModelRepository.findAll().stream()
                .map(aiModel -> new AiModelResponse(
                    aiModel.id().value(),
                    aiModel.providerModelId().value(),
                    aiModel.nameModel(),
                    aiModel.modelKey(),
                    aiModel.inputTokenPrice(),
                    aiModel.outputTokenPrice(),
                    aiModel.maxTokens(),
                    aiModel.contextWindow(),
                    aiModel.active(),
                    aiModel.createdAt(),
                    aiModel.updatedAt()
                ))
                .toList();
    }
}
