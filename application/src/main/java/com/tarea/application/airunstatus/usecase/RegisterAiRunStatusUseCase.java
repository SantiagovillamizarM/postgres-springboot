package com.tarea.application.airunstatus.usecase;

import com.tarea.application.airunstatus.command.RegisterAiRunStatusCommand;
import com.tarea.application.airunstatus.dto.AiRunStatusResponse;
import com.tarea.domain.airunstatus.model.aggregate.AiRunStatus;
import com.tarea.domain.airunstatus.port.repository.AiRunStatusRepository;

public class RegisterAiRunStatusUseCase {

    private final AiRunStatusRepository aiRunStatusRepository;

    public RegisterAiRunStatusUseCase(AiRunStatusRepository aiRunStatusRepository) {
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public AiRunStatusResponse execute(RegisterAiRunStatusCommand command) {
        AiRunStatus aiRunStatus = AiRunStatus.register(
                command.nameStatus()
        );

        AiRunStatus saved = aiRunStatusRepository.save(aiRunStatus);

        return new AiRunStatusResponse(
            saved.id().value(),
            saved.nameStatus(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
