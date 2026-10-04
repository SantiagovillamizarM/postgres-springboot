package com.tarea.application.escalationstatus.usecase;

import com.tarea.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.tarea.domain.escalationstatus.model.valueobject.EscalationStatusId;
import com.tarea.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class DeleteEscalationStatusUseCase {

    private final EscalationStatusRepository escalationStatusRepository;

    public DeleteEscalationStatusUseCase(EscalationStatusRepository escalationStatusRepository) {
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public void execute(EscalationStatusId id) {
        var escalationStatus = escalationStatusRepository.findById(id)
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(id.value().toString()));

        escalationStatus.markAsDeleted();
        escalationStatusRepository.delete(escalationStatus);
    }
}
