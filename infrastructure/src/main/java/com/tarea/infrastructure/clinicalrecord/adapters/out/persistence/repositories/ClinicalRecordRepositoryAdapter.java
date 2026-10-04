package com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.repositories;

import com.tarea.domain.clinicalrecord.model.aggregate.ClinicalRecord;
import com.tarea.domain.clinicalrecord.model.valueobject.ClinicalRecordId;
import com.tarea.domain.clinicalrecord.port.repository.ClinicalRecordRepository;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.entity.ClinicalRecordJpaEntity;
import com.tarea.infrastructure.clinicalrecord.adapters.out.persistence.mappers.ClinicalRecordPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ClinicalRecordRepositoryAdapter implements ClinicalRecordRepository {

    private final ClinicalRecordJpaRepository clinicalRecordJpaRepository;
    private final ClinicalRecordPersistenceMapper mapper;

    public ClinicalRecordRepositoryAdapter(ClinicalRecordJpaRepository clinicalRecordJpaRepository, ClinicalRecordPersistenceMapper mapper) {
        this.clinicalRecordJpaRepository = clinicalRecordJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ClinicalRecord save(ClinicalRecord clinicalRecord) {
        ClinicalRecordJpaEntity entity = mapper.toJpa(clinicalRecord);
        ClinicalRecordJpaEntity saved = clinicalRecordJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ClinicalRecord> findById(ClinicalRecordId id) {
        return clinicalRecordJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ClinicalRecord> findAll() {
        return clinicalRecordJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ClinicalRecord clinicalRecord) {
        clinicalRecordJpaRepository.deleteById(clinicalRecord.id().value());
    }
}
