package com.tarea.infrastructure.riskassessment.adapters.out.persistence.repositories;

import com.tarea.domain.riskassessment.model.aggregate.RiskAssessment;
import com.tarea.domain.riskassessment.model.valueobject.RiskAssessmentId;
import com.tarea.domain.riskassessment.port.repository.RiskAssessmentRepository;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.entity.RiskAssessmentJpaEntity;
import com.tarea.infrastructure.riskassessment.adapters.out.persistence.mappers.RiskAssessmentPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class RiskAssessmentRepositoryAdapter implements RiskAssessmentRepository {

    private final RiskAssessmentJpaRepository riskAssessmentJpaRepository;
    private final RiskAssessmentPersistenceMapper mapper;

    public RiskAssessmentRepositoryAdapter(RiskAssessmentJpaRepository riskAssessmentJpaRepository, RiskAssessmentPersistenceMapper mapper) {
        this.riskAssessmentJpaRepository = riskAssessmentJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public RiskAssessment save(RiskAssessment riskAssessment) {
        RiskAssessmentJpaEntity entity = mapper.toJpa(riskAssessment);
        RiskAssessmentJpaEntity saved = riskAssessmentJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RiskAssessment> findById(RiskAssessmentId id) {
        return riskAssessmentJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<RiskAssessment> findAll() {
        return riskAssessmentJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(RiskAssessment riskAssessment) {
        riskAssessmentJpaRepository.deleteById(riskAssessment.id().value());
    }
}
