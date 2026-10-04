package com.tarea.infrastructure.risklevel.adapters.out.persistence.repositories;

import com.tarea.domain.risklevel.model.aggregate.RiskLevel;
import com.tarea.domain.risklevel.model.valueobject.RiskLevelId;
import com.tarea.domain.risklevel.port.repository.RiskLevelRepository;
import com.tarea.infrastructure.risklevel.adapters.out.persistence.entity.RiskLevelJpaEntity;
import com.tarea.infrastructure.risklevel.adapters.out.persistence.mappers.RiskLevelPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class RiskLevelRepositoryAdapter implements RiskLevelRepository {

    private final RiskLevelJpaRepository riskLevelJpaRepository;
    private final RiskLevelPersistenceMapper mapper;

    public RiskLevelRepositoryAdapter(RiskLevelJpaRepository riskLevelJpaRepository, RiskLevelPersistenceMapper mapper) {
        this.riskLevelJpaRepository = riskLevelJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public RiskLevel save(RiskLevel riskLevel) {
        RiskLevelJpaEntity entity = mapper.toJpa(riskLevel);
        RiskLevelJpaEntity saved = riskLevelJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RiskLevel> findById(RiskLevelId id) {
        return riskLevelJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<RiskLevel> findAll() {
        return riskLevelJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return riskLevelJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(RiskLevel riskLevel) {
        riskLevelJpaRepository.deleteById(riskLevel.id().value());
    }
}
