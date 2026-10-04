package com.tarea.application.encountertype.usecase;

import com.tarea.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.encountertype.port.repository.EncounterTypeRepository;

public class DeleteEncounterTypeUseCase {

    private final EncounterTypeRepository encounterTypeRepository;

    public DeleteEncounterTypeUseCase(EncounterTypeRepository encounterTypeRepository) {
        this.encounterTypeRepository = encounterTypeRepository;
    }

    public void execute(EncounterTypeId id) {
        var encounterType = encounterTypeRepository.findById(id)
                .orElseThrow(() -> new EncounterTypeNotFoundApplicationException(id.value().toString()));

        encounterType.markAsDeleted();
        encounterTypeRepository.delete(encounterType);
    }
}
