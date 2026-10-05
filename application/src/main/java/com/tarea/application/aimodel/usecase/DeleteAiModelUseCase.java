//Este es el lugar en donde esta alamacenado este archivo .java
package com.tarea.application.aimodel.usecase;

import com.tarea.application.aimodel.exception.AiModelNotFoundApplicationException;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;

public class DeleteAiModelUseCase {

    private final AiModelRepository aiModelRepository;

    public DeleteAiModelUseCase(AiModelRepository aiModelRepository) {
        this.aiModelRepository = aiModelRepository;
    }

    public void execute(AiModelId id) {
        var aiModel = aiModelRepository.findById(id)
                .orElseThrow(() -> new AiModelNotFoundApplicationException(id.value().toString()));

        aiModel.markAsDeleted();
        aiModelRepository.delete(aiModel);
    }
}
