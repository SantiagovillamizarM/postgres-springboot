package com.tarea.application.airunstatus.usecase;

import com.tarea.application.airunstatus.dto.AiRunStatusResponse;
import com.tarea.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.airunstatus.port.repository.AiRunStatusRepository;

public class GetAiRunStatusByIdUseCase {

    private final AiRunStatusRepository aiRunStatusRepository;

    public GetAiRunStatusByIdUseCase(AiRunStatusRepository aiRunStatusRepository) {
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public AiRunStatusResponse execute(AiRunStatusId id) {
        var aiRunStatus = aiRunStatusRepository.findById(id)
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(id.value().toString()));

        return new AiRunStatusResponse(
            aiRunStatus.id().value(),
            aiRunStatus.nameStatus(),
            aiRunStatus.createdAt(),
            aiRunStatus.updatedAt()
        );
    }
}
