package com.tarea.application.encounterstatus.usecase;

import com.tarea.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class DeleteEncounterStatusUseCase {

    private final EncounterStatusRepository encounterStatusRepository;

    public DeleteEncounterStatusUseCase(EncounterStatusRepository encounterStatusRepository) {
        this.encounterStatusRepository = encounterStatusRepository;
    }

    public void execute(EncounterStatusId id) {
        var encounterStatus = encounterStatusRepository.findById(id)
                .orElseThrow(() -> new EncounterStatusNotFoundApplicationException(id.value().toString()));

        encounterStatus.markAsDeleted();
        encounterStatusRepository.delete(encounterStatus);
    }
}
