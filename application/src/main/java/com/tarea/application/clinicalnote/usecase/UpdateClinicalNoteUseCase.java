package com.tarea.application.clinicalnote.usecase;

import com.tarea.application.clinicalnote.command.UpdateClinicalNoteCommand;
import com.tarea.application.clinicalnote.dto.ClinicalNoteResponse;
import com.tarea.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.tarea.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class UpdateClinicalNoteUseCase {

    private final ClinicalNoteRepository clinicalNoteRepository;

    public UpdateClinicalNoteUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        this.clinicalNoteRepository = clinicalNoteRepository;
    }

    public ClinicalNoteResponse execute(UpdateClinicalNoteCommand command) {
        var clinicalNote = clinicalNoteRepository.findById(command.id())
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(command.id().value().toString()));

        clinicalNote.update(
                command.encounterId(),
                command.professionalId(),
                command.subjective(),
                command.objective(),
                command.assessment(),
                command.plan(),
                command.additionalNotes(),
                command.signedAt()
        );

        var updated = clinicalNoteRepository.save(clinicalNote);

        return new ClinicalNoteResponse(
            updated.id().value(),
            updated.encounterId().value(),
            updated.professionalId().value(),
            updated.subjective(),
            updated.objective(),
            updated.assessment(),
            updated.plan(),
            updated.additionalNotes(),
            updated.signedAt(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
