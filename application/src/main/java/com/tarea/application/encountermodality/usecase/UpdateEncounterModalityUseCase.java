package com.tarea.application.encountermodality.usecase;

import com.tarea.application.encountermodality.command.UpdateEncounterModalityCommand;
import com.tarea.application.encountermodality.dto.EncounterModalityResponse;
import com.tarea.application.encountermodality.exception.EncounterModalityNotFoundApplicationException;
import com.tarea.domain.encountermodality.port.repository.EncounterModalityRepository;

public class UpdateEncounterModalityUseCase {

    private final EncounterModalityRepository encounterModalityRepository;

    public UpdateEncounterModalityUseCase(EncounterModalityRepository encounterModalityRepository) {
        this.encounterModalityRepository = encounterModalityRepository;
    }

    public EncounterModalityResponse execute(UpdateEncounterModalityCommand command) {
        var encounterModality = encounterModalityRepository.findById(command.id())
                .orElseThrow(() -> new EncounterModalityNotFoundApplicationException(command.id().value().toString()));

        encounterModality.update(
                command.code(),
                command.name(),
                command.active()
        );

        var updated = encounterModalityRepository.save(encounterModality);

        return new EncounterModalityResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
