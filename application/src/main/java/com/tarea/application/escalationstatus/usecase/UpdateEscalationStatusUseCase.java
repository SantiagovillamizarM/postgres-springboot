package com.tarea.application.escalationstatus.usecase;

import com.tarea.application.escalationstatus.command.UpdateEscalationStatusCommand;
import com.tarea.application.escalationstatus.dto.EscalationStatusResponse;
import com.tarea.application.escalationstatus.exception.EscalationStatusNotFoundApplicationException;
import com.tarea.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class UpdateEscalationStatusUseCase {

    private final EscalationStatusRepository escalationStatusRepository;

    public UpdateEscalationStatusUseCase(EscalationStatusRepository escalationStatusRepository) {
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public EscalationStatusResponse execute(UpdateEscalationStatusCommand command) {
        var escalationStatus = escalationStatusRepository.findById(command.id())
                .orElseThrow(() -> new EscalationStatusNotFoundApplicationException(command.id().value().toString()));

        escalationStatus.update(
                command.nameStatus()
        );

        var updated = escalationStatusRepository.save(escalationStatus);

        return new EscalationStatusResponse(
            updated.id().value(),
            updated.nameStatus(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
