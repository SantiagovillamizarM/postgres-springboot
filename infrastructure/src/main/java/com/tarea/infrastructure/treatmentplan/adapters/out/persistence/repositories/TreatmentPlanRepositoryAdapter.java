package com.tarea.infrastructure.treatmentplan.adapters.out.persistence.repositories;

import com.tarea.domain.treatmentplan.model.aggregate.TreatmentPlan;
import com.tarea.domain.treatmentplan.model.valueobject.TreatmentPlanId;
import com.tarea.domain.treatmentplan.port.repository.TreatmentPlanRepository;
import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.entity.TreatmentPlanJpaEntity;
import com.tarea.infrastructure.treatmentplan.adapters.out.persistence.mappers.TreatmentPlanPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class TreatmentPlanRepositoryAdapter implements TreatmentPlanRepository {

    private final TreatmentPlanJpaRepository treatmentPlanJpaRepository;
    private final TreatmentPlanPersistenceMapper mapper;

    public TreatmentPlanRepositoryAdapter(TreatmentPlanJpaRepository treatmentPlanJpaRepository, TreatmentPlanPersistenceMapper mapper) {
        this.treatmentPlanJpaRepository = treatmentPlanJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public TreatmentPlan save(TreatmentPlan treatmentPlan) {
        TreatmentPlanJpaEntity entity = mapper.toJpa(treatmentPlan);
        TreatmentPlanJpaEntity saved = treatmentPlanJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<TreatmentPlan> findById(TreatmentPlanId id) {
        return treatmentPlanJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<TreatmentPlan> findAll() {
        return treatmentPlanJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(TreatmentPlan treatmentPlan) {
        treatmentPlanJpaRepository.deleteById(treatmentPlan.id().value());
    }
}
