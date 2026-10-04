package com.tarea.application.encounterstatus.usecase;

import com.tarea.application.encounterstatus.command.RegisterEncounterStatusCommand;
import com.tarea.application.encounterstatus.dto.EncounterStatusResponse;
import com.tarea.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.tarea.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class RegisterEncounterStatusUseCase {

    private final EncounterStatusRepository encounterStatusRepository;

    public RegisterEncounterStatusUseCase(EncounterStatusRepository encounterStatusRepository) {
        this.encounterStatusRepository = encounterStatusRepository;
    }

    public EncounterStatusResponse execute(RegisterEncounterStatusCommand command) {
        EncounterStatus encounterStatus = EncounterStatus.register(
                command.code(),
                command.name(),
                command.active()
        );

        EncounterStatus saved = encounterStatusRepository.save(encounterStatus);

        return new EncounterStatusResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
