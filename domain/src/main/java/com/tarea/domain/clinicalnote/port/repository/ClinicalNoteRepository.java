package com.tarea.domain.clinicalnote.port.repository;

import com.tarea.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;

import java.util.List;
import java.util.Optional;

public interface ClinicalNoteRepository {
    ClinicalNote save(ClinicalNote clinicalNote);
    Optional<ClinicalNote> findById(ClinicalNoteId id);
    List<ClinicalNote> findAll();
    void delete(ClinicalNote clinicalNote);
}
