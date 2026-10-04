package com.tarea.application.encounter.usecase;

import com.tarea.application.encounter.exception.EncounterNotFoundApplicationException;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.encounter.port.repository.EncounterRepository;

public class DeleteEncounterUseCase {

    private final EncounterRepository encounterRepository;

    public DeleteEncounterUseCase(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    public void execute(EncounterId id) {
        var encounter = encounterRepository.findById(id)
                .orElseThrow(() -> new EncounterNotFoundApplicationException(id.value().toString()));

        encounter.markAsDeleted();
        encounterRepository.delete(encounter);
    }
}
