package com.tarea.application.encountertype.usecase;

import com.tarea.application.encountertype.command.UpdateEncounterTypeCommand;
import com.tarea.application.encountertype.dto.EncounterTypeResponse;
import com.tarea.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.tarea.domain.encountertype.port.repository.EncounterTypeRepository;

public class UpdateEncounterTypeUseCase {

    private final EncounterTypeRepository encounterTypeRepository;

    public UpdateEncounterTypeUseCase(EncounterTypeRepository encounterTypeRepository) {
        this.encounterTypeRepository = encounterTypeRepository;
    }

    public EncounterTypeResponse execute(UpdateEncounterTypeCommand command) {
        var encounterType = encounterTypeRepository.findById(command.id())
                .orElseThrow(() -> new EncounterTypeNotFoundApplicationException(command.id().value().toString()));

        encounterType.update(
                command.code(),
                command.name(),
                command.active()
        );

        var updated = encounterTypeRepository.save(encounterType);

        return new EncounterTypeResponse(
            updated.id().value(),
            updated.code(),
            updated.name(),
            updated.active(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
