//Este es el lugar en donde esta alamacenado este archivo .java
package com.tarea.application.aimodel.usecase;

import com.tarea.application.aimodel.dto.AiModelResponse;
import com.tarea.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;

public class GetAiModelByIdUseCase {

    private final AiModelRepository aiModelRepository;

    public GetAiModelByIdUseCase(AiModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    public AiModelResponse execute(AiModelId id) {
        var aiModel = aiModelRepository.findById(id)
                .orElseThrow(() -> new AiModelNotFoundApplicationException(id.value().toString()));

        return new AiModelResponse(
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
        );
    }
}
