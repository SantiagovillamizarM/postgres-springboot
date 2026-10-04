package com.tarea.application.escalationstatus.usecase;

import com.tarea.application.escalationstatus.command.RegisterEscalationStatusCommand;
import com.tarea.application.escalationstatus.dto.EscalationStatusResponse;
import com.tarea.domain.escalationstatus.model.aggregate.EscalationStatus;
import com.tarea.domain.escalationstatus.port.repository.EscalationStatusRepository;

public class RegisterEscalationStatusUseCase {

    private final EscalationStatusRepository escalationStatusRepository;

    public RegisterEscalationStatusUseCase(EscalationStatusRepository escalationStatusRepository) {
        this.escalationStatusRepository = escalationStatusRepository;
    }

    public EscalationStatusResponse execute(RegisterEscalationStatusCommand command) {
        EscalationStatus escalationStatus = EscalationStatus.register(
                command.nameStatus()
        );

        EscalationStatus saved = escalationStatusRepository.save(escalationStatus);

        return new EscalationStatusResponse(
            saved.id().value(),
            saved.nameStatus(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
