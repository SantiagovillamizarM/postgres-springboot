package com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.repositories;

import com.tarea.domain.treatmentstatus.model.aggregate.TreatmentStatus;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;
import com.tarea.domain.treatmentstatus.port.repository.TreatmentStatusRepository;
import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.entity.TreatmentStatusJpaEntity;
import com.tarea.infrastructure.treatmentstatus.adapters.out.persistence.mappers.TreatmentStatusPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class TreatmentStatusRepositoryAdapter implements TreatmentStatusRepository {

    private final TreatmentStatusJpaRepository treatmentStatusJpaRepository;
    private final TreatmentStatusPersistenceMapper mapper;

    public TreatmentStatusRepositoryAdapter(TreatmentStatusJpaRepository treatmentStatusJpaRepository, TreatmentStatusPersistenceMapper mapper) {
        this.treatmentStatusJpaRepository = treatmentStatusJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentStatus save(TreatmentStatus treatmentStatus) {
        TreatmentStatusJpaEntity entity = mapper.toJpa(treatmentStatus);
        TreatmentStatusJpaEntity saved = treatmentStatusJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentStatus> findById(TreatmentStatusId id) {
        return treatmentStatusJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<TreatmentStatus> findAll() {
        return treatmentStatusJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return treatmentStatusJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(TreatmentStatus treatmentStatus) {
        treatmentStatusJpaRepository.deleteById(treatmentStatus.id().value());
    }
}
