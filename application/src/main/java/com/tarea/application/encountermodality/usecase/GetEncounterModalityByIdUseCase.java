package com.tarea.application.encountermodality.usecase;

import com.tarea.application.encountermodality.dto.EncounterModalityResponse;
import com.tarea.application.encountermodality.exception.EncounterModalityNotFoundApplicationException;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encountermodality.port.repository.EncounterModalityRepository;

public class GetEncounterModalityByIdUseCase {

    private final EncounterModalityRepository encounterModalityRepository;

    public GetEncounterModalityByIdUseCase(EncounterModalityRepository encounterModalityRepository) {
        this.encounterModalityRepository = encounterModalityRepository;
    }

    public EncounterModalityResponse execute(EncounterModalityId id) {
        var encounterModality = encounterModalityRepository.findById(id)
                .orElseThrow(() -> new EncounterModalityNotFoundApplicationException(id.value().toString()));

        return new EncounterModalityResponse(
            encounterModality.id().value(),
            encounterModality.code(),
            encounterModality.name(),
            encounterModality.active(),
            encounterModality.createdAt(),
            encounterModality.updatedAt()
        );
    }
}
