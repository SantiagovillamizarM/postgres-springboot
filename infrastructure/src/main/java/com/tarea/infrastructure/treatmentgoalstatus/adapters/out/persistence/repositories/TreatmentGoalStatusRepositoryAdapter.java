package com.tarea.infrastructure.treatmentgoalstatus.adapters.out.persistence.repositories;

import com.tarea.domain.treatmentgoalstatus.model.aggregate.TreatmentGoalStatus;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;
import com.tarea.domain.treatmentgoalstatus.port.repository.TreatmentGoalStatusRepository;
import com.tarea.infrastructure.treatmentgoalstatus.adapters.out.persistence.entity.TreatmentGoalStatusJpaEntity;
import com.tarea.infrastructure.treatmentgoalstatus.adapters.out.persistence.mappers.TreatmentGoalStatusPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class TreatmentGoalStatusRepositoryAdapter implements TreatmentGoalStatusRepository {

    private final TreatmentGoalStatusJpaRepository treatmentGoalStatusJpaRepository;
    private final TreatmentGoalStatusPersistenceMapper mapper;

    public TreatmentGoalStatusRepositoryAdapter(TreatmentGoalStatusJpaRepository treatmentGoalStatusJpaRepository, TreatmentGoalStatusPersistenceMapper mapper) {
        this.treatmentGoalStatusJpaRepository = treatmentGoalStatusJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentGoalStatus save(TreatmentGoalStatus treatmentGoalStatus) {
        TreatmentGoalStatusJpaEntity entity = mapper.toJpa(treatmentGoalStatus);
        TreatmentGoalStatusJpaEntity saved = treatmentGoalStatusJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentGoalStatus> findById(TreatmentGoalStatusId id) {
        return treatmentGoalStatusJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<TreatmentGoalStatus> findAll() {
        return treatmentGoalStatusJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return treatmentGoalStatusJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(TreatmentGoalStatus treatmentGoalStatus) {
        treatmentGoalStatusJpaRepository.deleteById(treatmentGoalStatus.id().value());
    }
}
