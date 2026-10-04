package com.tarea.application.airunstatus.usecase;

import com.tarea.application.airunstatus.dto.AiRunStatusResponse;
import com.tarea.domain.airunstatus.port.repository.AiRunStatusRepository;

import java.util.List;

public class ListAiRunStatusUseCase {

    private final AiRunStatusRepository aiRunStatusRepository;

    public ListAiRunStatusUseCase(AiRunStatusRepository aiRunStatusRepository) {
        this.aiRunStatusRepository = aiRunStatusRepository;
    }

    public List<AiRunStatusResponse> execute() {
        return aiRunStatusRepository.findAll().stream()
                .map(aiRunStatus -> new AiRunStatusResponse(
                    aiRunStatus.id().value(),
                    aiRunStatus.nameStatus(),
                    aiRunStatus.createdAt(),
                    aiRunStatus.updatedAt()
                ))
                .toList();
    }
}
