package com.tarea.application.clinicalnote.usecase;

import com.tarea.application.clinicalnote.exception.ClinicalNoteNotFoundApplicationException;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.tarea.domain.clinicalnote.port.repository.ClinicalNoteRepository;

public class DeleteClinicalNoteUseCase {

    private final ClinicalNoteRepository clinicalNoteRepository;

    public DeleteClinicalNoteUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        this.clinicalNoteRepository = clinicalNoteRepository;
    }

    public void execute(ClinicalNoteId id) {
        var clinicalNote = clinicalNoteRepository.findById(id)
                .orElseThrow(() -> new ClinicalNoteNotFoundApplicationException(id.value().toString()));

        clinicalNote.markAsDeleted();
        clinicalNoteRepository.delete(clinicalNote);
    }
}
