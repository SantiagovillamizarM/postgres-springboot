package com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.repositories;

import com.tarea.domain.treatmentgoal.model.aggregate.TreatmentGoal;
import com.tarea.domain.treatmentgoal.model.valueobject.TreatmentGoalId;
import com.tarea.domain.treatmentgoal.port.repository.TreatmentGoalRepository;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.entity.TreatmentGoalJpaEntity;
import com.tarea.infrastructure.treatmentgoal.adapters.out.persistence.mappers.TreatmentGoalPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class TreatmentGoalRepositoryAdapter implements TreatmentGoalRepository {

    private final TreatmentGoalJpaRepository treatmentGoalJpaRepository;
    private final TreatmentGoalPersistenceMapper mapper;

    public TreatmentGoalRepositoryAdapter(TreatmentGoalJpaRepository treatmentGoalJpaRepository, TreatmentGoalPersistenceMapper mapper) {
        this.treatmentGoalJpaRepository = treatmentGoalJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentGoal save(TreatmentGoal treatmentGoal) {
        TreatmentGoalJpaEntity entity = mapper.toJpa(treatmentGoal);
        TreatmentGoalJpaEntity saved = treatmentGoalJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentGoal> findById(TreatmentGoalId id) {
        return treatmentGoalJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<TreatmentGoal> findAll() {
        return treatmentGoalJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(TreatmentGoal treatmentGoal) {
        treatmentGoalJpaRepository.deleteById(treatmentGoal.id().value());
    }
}
