package com.tarea.application.clinicalnote.usecase;

import com.tarea.application.clinicalnote.command.RegisterClinicalNoteCommand;
import com.tarea.application.clinicalnote.dto.ClinicalNoteResponse;
import com.tarea.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.tarea.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class RegisterClinicalNoteUseCase {

    private final ClinicalNoteRepository clinicalNoteRepository;

    public RegisterClinicalNoteUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        this.clinicalNoteRepository = clinicalNoteRepository;
    }

    public ClinicalNoteResponse execute(RegisterClinicalNoteCommand command) {
        ClinicalNote clinicalNote = ClinicalNote.register(
                command.encounterId(),
                command.professionalId(),
                command.subjective(),
                command.objective(),
                command.assessment(),
                command.plan(),
                command.additionalNotes(),
                command.signedAt()
        );

        ClinicalNote saved = clinicalNoteRepository.save(clinicalNote);

        return new ClinicalNoteResponse(
            saved.id().value(),
            saved.encounterId().value(),
            saved.professionalId().value(),
            saved.subjective(),
            saved.objective(),
            saved.assessment(),
            saved.plan(),
            saved.additionalNotes(),
            saved.signedAt(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
