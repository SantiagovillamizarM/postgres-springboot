package com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.repositories;

import com.tarea.domain.clinicalrecordstatus.model.aggregate.ClinicalRecordStatus;
import com.tarea.domain.clinicalrecordstatus.model.valueobject.ClinicalRecordStatusId;
import com.tarea.domain.clinicalrecordstatus.port.repository.ClinicalRecordStatusRepository;
import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.entity.ClinicalRecordStatusJpaEntity;
import com.tarea.infrastructure.clinicalrecordstatus.adapters.out.persistence.mappers.ClinicalRecordStatusPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ClinicalRecordStatusRepositoryAdapter implements ClinicalRecordStatusRepository {

    private final ClinicalRecordStatusJpaRepository clinicalRecordStatusJpaRepository;
    private final ClinicalRecordStatusPersistenceMapper mapper;

    public ClinicalRecordStatusRepositoryAdapter(ClinicalRecordStatusJpaRepository clinicalRecordStatusJpaRepository, ClinicalRecordStatusPersistenceMapper mapper) {
        this.clinicalRecordStatusJpaRepository = clinicalRecordStatusJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ClinicalRecordStatus save(ClinicalRecordStatus clinicalRecordStatus) {
        ClinicalRecordStatusJpaEntity entity = mapper.toJpa(clinicalRecordStatus);
        ClinicalRecordStatusJpaEntity saved = clinicalRecordStatusJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ClinicalRecordStatus> findById(ClinicalRecordStatusId id) {
        return clinicalRecordStatusJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ClinicalRecordStatus> findAll() {
        return clinicalRecordStatusJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return clinicalRecordStatusJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(ClinicalRecordStatus clinicalRecordStatus) {
        clinicalRecordStatusJpaRepository.deleteById(clinicalRecordStatus.id().value());
    }
}
