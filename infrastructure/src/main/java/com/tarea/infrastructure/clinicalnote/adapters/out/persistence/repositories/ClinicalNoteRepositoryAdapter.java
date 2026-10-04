package com.tarea.infrastructure.clinicalnote.adapters.out.persistence.repositories;

import com.tarea.domain.clinicalnote.model.aggregate.ClinicalNote;
import com.tarea.domain.clinicalnote.model.valueobject.ClinicalNoteId;
import com.tarea.domain.clinicalnote.port.repository.ClinicalNoteRepository;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.entity.ClinicalNoteJpaEntity;
import com.tarea.infrastructure.clinicalnote.adapters.out.persistence.mappers.ClinicalNotePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ClinicalNoteRepositoryAdapter implements ClinicalNoteRepository {

    private final ClinicalNoteJpaRepository clinicalNoteJpaRepository;
    private final ClinicalNotePersistenceMapper mapper;

    public ClinicalNoteRepositoryAdapter(ClinicalNoteJpaRepository clinicalNoteJpaRepository, ClinicalNotePersistenceMapper mapper) {
        this.clinicalNoteJpaRepository = clinicalNoteJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ClinicalNote save(ClinicalNote clinicalNote) {
        ClinicalNoteJpaEntity entity = mapper.toJpa(clinicalNote);
        ClinicalNoteJpaEntity saved = clinicalNoteJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ClinicalNote> findById(ClinicalNoteId id) {
        return clinicalNoteJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ClinicalNote> findAll() {
        return clinicalNoteJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ClinicalNote clinicalNote) {
        clinicalNoteJpaRepository.deleteById(clinicalNote.id().value());
    }
}
