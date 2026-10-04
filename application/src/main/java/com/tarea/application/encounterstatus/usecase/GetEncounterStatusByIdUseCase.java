package com.tarea.application.encounterstatus.usecase;

import com.tarea.application.encounterstatus.dto.EncounterStatusResponse;
import com.tarea.application.encounterstatus.exception.EncounterStatusNotFoundApplicationException;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encounterstatus.port.repository.EncounterStatusRepository;

public class GetEncounterStatusByIdUseCase {

    private final EncounterStatusRepository encounterStatusRepository;

    public GetEncounterStatusByIdUseCase(EncounterStatusRepository encounterStatusRepository) {
        this.encounterStatusRepository = encounterStatusRepository;
    }

    public EncounterStatusResponse execute(EncounterStatusId id) {
        var encounterStatus = encounterStatusRepository.findById(id)
                .orElseThrow(() -> new EncounterStatusNotFoundApplicationException(id.value().toString()));

        return new EncounterStatusResponse(
            encounterStatus.id().value(),
            encounterStatus.code(),
            encounterStatus.name(),
            encounterStatus.active(),
            encounterStatus.createdAt(),
            encounterStatus.updatedAt()
        );
    }
}
