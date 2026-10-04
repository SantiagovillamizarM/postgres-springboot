package com.tarea.application.encounter.usecase;

import com.tarea.application.encounter.dto.EncounterResponse;
import com.tarea.application.encounter.exception.EncounterNotFoundApplicationException;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.encounter.port.repository.EncounterRepository;

public class GetEncounterByIdUseCase {

    private final EncounterRepository encounterRepository;

    public GetEncounterByIdUseCase(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    public EncounterResponse execute(EncounterId id) {
        var encounter = encounterRepository.findById(id)
                .orElseThrow(() -> new EncounterNotFoundApplicationException(id.value().toString()));

        return new EncounterResponse(
            encounter.id().value(),
            encounter.clinicalRecordId().value(),
            encounter.professionalId().value(),
            encounter.encounterTypeId().value(),
            encounter.startedAt(),
            encounter.endedAt(),
            encounter.reasonForVisit(),
            encounter.currentCondition(),
            encounter.modalityId().value(),
            encounter.statusId().value(),
            encounter.createdBy() != null ? encounter.createdBy().value() : null,
            encounter.updatedBy() != null ? encounter.updatedBy().value() : null,
            encounter.createdAt(),
            encounter.updatedAt()
        );
    }
}
