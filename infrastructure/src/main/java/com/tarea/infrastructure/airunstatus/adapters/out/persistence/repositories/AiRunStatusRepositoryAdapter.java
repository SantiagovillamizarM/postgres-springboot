package com.tarea.infrastructure.airunstatus.adapters.out.persistence.repositories;

import com.tarea.domain.airunstatus.model.aggregate.AiRunStatus;
import com.tarea.domain.airunstatus.model.valueobject.AiRunStatusId;
import com.tarea.domain.airunstatus.port.repository.AiRunStatusRepository;
import com.tarea.infrastructure.airunstatus.adapters.out.persistence.entity.AiRunStatusJpaEntity;
import com.tarea.infrastructure.airunstatus.adapters.out.persistence.mappers.AiRunStatusPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class AiRunStatusRepositoryAdapter implements AiRunStatusRepository {

    private final AiRunStatusJpaRepository aiRunStatusJpaRepository;
    private final AiRunStatusPersistenceMapper mapper;

    public AiRunStatusRepositoryAdapter(AiRunStatusJpaRepository aiRunStatusJpaRepository, AiRunStatusPersistenceMapper mapper) {
        this.aiRunStatusJpaRepository = aiRunStatusJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public AiRunStatus save(AiRunStatus aiRunStatus) {
        AiRunStatusJpaEntity entity = mapper.toJpa(aiRunStatus);
        AiRunStatusJpaEntity saved = aiRunStatusJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<AiRunStatus> findById(AiRunStatusId id) {
        return aiRunStatusJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<AiRunStatus> findAll() {
        return aiRunStatusJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(AiRunStatus aiRunStatus) {
        aiRunStatusJpaRepository.deleteById(aiRunStatus.id().value());
    }
}
