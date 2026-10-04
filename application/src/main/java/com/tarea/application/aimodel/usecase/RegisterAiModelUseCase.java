package com.tarea.application.aimodel.usecase;

import com.tarea.application.aimodel.command.RegisterAiModelCommand;
import com.tarea.application.aimodel.dto.AiModelResponse;
import com.tarea.domain.aimodel.model.aggregate.AiModel;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;

public class RegisterAiModelUseCase {

    private final AiModelRepository aiModelRepository;

    public RegisterAiModelUseCase(AiModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    public AiModelResponse execute(RegisterAiModelCommand command) {
        AiModel aiModel = AiModel.register(
                command.providerModelId(),
                command.nameModel(),
                command.modelKey(),
                command.inputTokenPrice(),
                command.outputTokenPrice(),
                command.maxTokens(),
                command.contextWindow(),
                command.active()
        );

        AiModel saved = aiModelRepository.save(aiModel);

        return new AiModelResponse(
            saved.id().value(),
            saved.providerModelId().value(),
            saved.nameModel(),
            saved.modelKey(),
            saved.inputTokenPrice(),
            saved.outputTokenPrice(),
            saved.maxTokens(),
            saved.contextWindow(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
