package com.tarea.application.encounter.usecase;

import com.tarea.application.encounter.dto.EncounterResponse;
import com.tarea.domain.encounter.port.repository.EncounterRepository;

import java.util.List;

public class ListEncounterUseCase {

    private final EncounterRepository encounterRepository;

    public ListEncounterUseCase(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    public List<EncounterResponse> execute() {
        return encounterRepository.findAll().stream()
                .map(encounter -> new EncounterResponse(
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
                ))
                .toList();
    }
}
