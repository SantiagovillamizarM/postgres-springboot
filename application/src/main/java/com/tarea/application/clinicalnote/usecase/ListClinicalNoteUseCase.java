package com.tarea.application.clinicalnote.usecase;

import com.tarea.application.clinicalnote.dto.ClinicalNoteResponse;
import com.tarea.domain.clinicalnote.port.repository.ClinicalNoteRepository;

import java.util.List;

public class ListClinicalNoteUseCase {

    private final ClinicalNoteRepository clinicalNoteRepository;

    public ListClinicalNoteUseCase(ClinicalNoteRepository clinicalNoteRepository) {
        this.clinicalNoteRepository = clinicalNoteRepository;
    }

    public List<ClinicalNoteResponse> execute() {
        return clinicalNoteRepository.findAll().stream()
                .map(clinicalNote -> new ClinicalNoteResponse(
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
                ))
                .toList();
    }
}
