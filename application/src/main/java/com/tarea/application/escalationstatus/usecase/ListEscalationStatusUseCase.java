package com.tarea.application.escalationstatus.usecase;

import com.tarea.application.escalationstatus.dto.EscalationStatusResponse;
import com.tarea.domain.escalationstatus.port.repository.EscalationStatusRepository;

import java.util.List;

public class ListEscalationStatusUseCase {

    private final EscalationStatusRepository escalationStatusRepository;

    public ListEscalationStatusUseCase(EscalationStatusRepository escalationStatusRepository) {
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public List<EscalationStatusResponse> execute() {
        return escalationStatusRepository.findAll().stream()
                .map(escalationStatus -> new EscalationStatusResponse(
                    escalationStatus.id().value(),
                    escalationStatus.nameStatus(),
                    escalationStatus.createdAt(),
                    escalationStatus.updatedAt()
                ))
                .toList();
    }
}
