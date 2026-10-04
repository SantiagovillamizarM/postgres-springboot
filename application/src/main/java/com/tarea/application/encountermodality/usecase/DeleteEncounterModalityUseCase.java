package com.tarea.application.encountermodality.usecase;

import com.tarea.application.encountermodality.exception.EncounterModalityNotFoundApplicationException;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encountermodality.port.repository.EncounterModalityRepository;

public class DeleteEncounterModalityUseCase {

    private final EncounterModalityRepository encounterModalityRepository;

    public DeleteEncounterModalityUseCase(EncounterModalityRepository encounterModalityRepository) {
        this.encounterModalityRepository = encounterModalityRepository;
    }

    public void execute(EncounterModalityId id) {
        var encounterModality = encounterModalityRepository.findById(id)
                .orElseThrow(() -> new EncounterModalityNotFoundApplicationException(id.value().toString()));

        encounterModality.markAsDeleted();
        encounterModalityRepository.delete(encounterModality);
    }
}
