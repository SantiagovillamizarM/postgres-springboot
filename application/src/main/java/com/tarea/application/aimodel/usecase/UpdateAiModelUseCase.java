//Este es el lugar en donde esta alamacenado este archivo .java
package com.tarea.application.aimodel.usecase;

import com.tarea.application.aimodel.command.UpdateAiModelCommand;
import com.tarea.application.aimodel.dto.AiModelResponse;
import com.tarea.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;

public class UpdateAiModelUseCase {

    private final AiModelRepository aiModelRepository;

    public UpdateAiModelUseCase(AiModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    public AiModelResponse execute(UpdateAiModelCommand command) {
        var aiModel = aiModelRepository.findById(command.id())
                .orElseThrow(() -> new AiModelNotFoundApplicationException(command.id().value().toString()));

        aiModel.update(
                command.providerModelId(),
                command.nameModel(),
                command.modelKey(),
                command.inputTokenPrice(),
                command.outputTokenPrice(),
                command.maxTokens(),
                command.contextWindow(),
                command.active()
        );

        var updated = aiModelRepository.save(aiModel);

        return new AiModelResponse(
            updated.id().value(),
            updated.providerModelId().value(),
            updated.nameModel(),
            updated.modelKey(),
            updated.inputTokenPrice(),
            updated.outputTokenPrice(),
            updated.maxTokens(),
            updated.contextWindow(),
            updated.active(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
