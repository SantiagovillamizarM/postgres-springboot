package com.tarea.application.encounter.usecase;

import com.tarea.application.encounter.command.UpdateEncounterCommand;
import com.tarea.application.encounter.dto.EncounterResponse;
import com.tarea.application.encounter.exception.EncounterNotFoundApplicationException;
import com.tarea.domain.encounter.port.repository.EncounterRepository;

public class UpdateEncounterUseCase {

    private final EncounterRepository encounterRepository;

    public UpdateEncounterUseCase(EncounterRepository encounterRepository) {
        this.encounterRepository = encounterRepository;
    }

    public EncounterResponse execute(UpdateEncounterCommand command) {
        var encounter = encounterRepository.findById(command.id())
                .orElseThrow(() -> new EncounterNotFoundApplicationException(command.id().value().toString()));

        encounter.update(
                command.clinicalRecordId(),
                command.professionalId(),
                command.encounterTypeId(),
                command.startedAt(),
                command.endedAt(),
                command.reasonForVisit(),
                command.currentCondition(),
                command.modalityId(),
                command.statusId(),
                command.updatedBy()
        );

        var updated = encounterRepository.save(encounter);

        return new EncounterResponse(
            updated.id().value(),
            updated.clinicalRecordId().value(),
            updated.professionalId().value(),
            updated.encounterTypeId().value(),
            updated.startedAt(),
            updated.endedAt(),
            updated.reasonForVisit(),
            updated.currentCondition(),
            updated.modalityId().value(),
            updated.statusId().value(),
            updated.createdBy() != null ? updated.createdBy().value() : null,
            updated.updatedBy() != null ? updated.updatedBy().value() : null,
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
