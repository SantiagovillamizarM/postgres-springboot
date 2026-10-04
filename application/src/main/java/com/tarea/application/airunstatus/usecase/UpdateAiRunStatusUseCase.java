package com.tarea.application.airunstatus.usecase;

import com.tarea.application.airunstatus.command.UpdateAiRunStatusCommand;
import com.tarea.application.airunstatus.dto.AiRunStatusResponse;
import com.tarea.application.airunstatus.exception.AiRunStatusNotFoundApplicationException;
import com.tarea.domain.airunstatus.port.repository.AiRunStatusRepository;

public class UpdateAiRunStatusUseCase {

    private final AiRunStatusRepository aiRunStatusRepository;

    public UpdateAiRunStatusUseCase(AiRunStatusRepository aiRunStatusRepository) {
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public AiRunStatusResponse execute(UpdateAiRunStatusCommand command) {
        var aiRunStatus = aiRunStatusRepository.findById(command.id())
                .orElseThrow(() -> new AiRunStatusNotFoundApplicationException(command.id().value().toString()));

        aiRunStatus.update(
                command.nameStatus()
        );

        var updated = aiRunStatusRepository.save(aiRunStatus);

        return new AiRunStatusResponse(
            updated.id().value(),
            updated.nameStatus(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
