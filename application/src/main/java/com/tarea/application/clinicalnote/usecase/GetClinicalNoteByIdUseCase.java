package com.tarea.application.clinicalnote.usecase;

import com.tarea.application.clinicalnote.dto.ClinicalNoteResponse;
import com.tarea.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.tarea.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class GetClinicalNoteByIdUseCase {

    private final ClinicalNoteRepository clinicalNoteRepository;

    public GetClinicalNoteByIdUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        this.clinicalNoteRepository = clinicalNoteRepository;
    }

    public ClinicalNoteResponse execute(ClinicalNoteId id) {
        var clinicalNote = clinicalNoteRepository.findById(id)
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(id.value().toString()));

        return new ClinicalNoteResponse(
            clinicalNote.id().value(),
            clinicalNote.encounterId().value(),
            clinicalNote.professionalId().value(),
            clinicalNote.subjective(),
            clinicalNote.objective(),
            clinicalNote.assessment(),
            clinicalNote.plan(),
            clinicalNote.additionalNotes(),
            clinicalNote.signedAt(),
            clinicalNote.createdAt(),
            clinicalNote.updatedAt()
        );
    }
}
