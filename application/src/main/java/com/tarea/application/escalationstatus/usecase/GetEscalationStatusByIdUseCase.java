package com.tarea.application.escalationstatus.usecase;

import com.tarea.application.escalationstatus.dto.EscalationStatusResponse;
import com.tarea.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class GetEscalationStatusByIdUseCase {

    private final EscalationStatusRepository escalationStatusRepository;

    public GetEscalationStatusByIdUseCase(EscalationStatusRepository escalationStatusRepository) {
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public EscalationStatusResponse execute(EscalationStatusId id) {
        var escalationStatus = escalationStatusRepository.findById(id)
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(id.value().toString()));

        return new EscalationStatusResponse(
            escalationStatus.id().value(),
            escalationStatus.nameStatus(),
            escalationStatus.createdAt(),
            escalationStatus.updatedAt()
        );
    }
}
