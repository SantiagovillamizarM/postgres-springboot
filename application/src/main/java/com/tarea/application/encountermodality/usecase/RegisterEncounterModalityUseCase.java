package com.tarea.application.encountermodality.usecase;

import com.tarea.application.encountermodality.command.RegisterEncounterModalityCommand;
import com.tarea.application.encountermodality.dto.EncounterModalityResponse;
import com.tarea.domain.encountermodality.model.aggregate.EncounterModality;
import com.tarea.domain.encountermodality.port.repository.EncounterModalityRepository;

public class RegisterEncounterModalityUseCase {

    private final EncounterModalityRepository encounterModalityRepository;

    public RegisterEncounterModalityUseCase(EncounterModalityRepository encounterModalityRepository) {
        this.encounterModalityRepository = encounterModalityRepository;
    }

    public EncounterModalityResponse execute(RegisterEncounterModalityCommand command) {
        EncounterModality encounterModality = EncounterModality.register(
                command.code(),
                command.name(),
                command.active()
        );

        EncounterModality saved = encounterModalityRepository.save(encounterModality);

        return new EncounterModalityResponse(
            saved.id().value(),
            saved.code(),
            saved.name(),
            saved.active(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
