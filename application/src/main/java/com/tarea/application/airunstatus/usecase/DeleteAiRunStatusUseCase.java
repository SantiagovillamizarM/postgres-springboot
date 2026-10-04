package com.tarea.application.airunstatus.usecase;

import com.tarea.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.airunstatus.port.repository.AiRunStatusRepository;

public class DeleteAiRunStatusUseCase {

    private final AiRunStatusRepository aiRunStatusRepository;

    public DeleteAiRunStatusUseCase(AiRunStatusRepository aiRunStatusRepository) {
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public void execute(AiRunStatusId id) {
        var aiRunStatus = aiRunStatusRepository.findById(id)
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(id.value().toString()));

        aiRunStatus.markAsDeleted();
        aiRunStatusRepository.delete(aiRunStatus);
    }
}
