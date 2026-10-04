package com.tarea.application.encountertype.usecase;

import com.tarea.application.encountertype.dto.EncounterTypeResponse;
import com.tarea.application.encountertype.exception.EncounterTypeNotFoundApplicationException;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.encountertype.port.repository.EncounterTypeRepository;

public class GetEncounterTypeByIdUseCase {

    private final EncounterTypeRepository encounterTypeRepository;

    public GetEncounterTypeByIdUseCase(EncounterTypeRepository encounterTypeRepository) {
        this.encounterTypeRepository = encounterTypeRepository;
    }

    public EncounterTypeResponse execute(EncounterTypeId id) {
        var encounterType = encounterTypeRepository.findById(id)
                .orElseThrow(() -> new EncounterTypeNotFoundApplicationException(id.value().toString()));

        return new EncounterTypeResponse(
            encounterType.id().value(),
            encounterType.code(),
            encounterType.name(),
            encounterType.active(),
            encounterType.createdAt(),
            encounterType.updatedAt()
        );
    }
}
