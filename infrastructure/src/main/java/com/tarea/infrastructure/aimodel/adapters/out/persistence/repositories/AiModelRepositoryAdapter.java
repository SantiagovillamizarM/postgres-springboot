package com.tarea.infrastructure.aimodel.adapters.out.persistence.repositories;

import com.tarea.domain.aimodel.model.aggregate.AiModel;
import com.tarea.domain.aimodel.model.valueobject.AiModelId;
import com.tarea.domain.aimodel.port.repository.AiModelRepository;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.entity.AiModelJpaEntity;
import com.tarea.infrastructure.aimodel.adapters.out.persistence.mappers.AiModelPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class AiModelRepositoryAdapter implements AiModelRepository {

    private final AiModelJpaRepository aiModelJpaRepository;
    private final AiModelPersistenceMapper mapper;

    public AiModelRepositoryAdapter(AiModelJpaRepository aiModelJpaRepository, AiModelPersistenceMapper mapper) {
        this.aiModelJpaRepository = aiModelJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public AiModel save(AiModel aiModel) {
        AiModelJpaEntity entity = mapper.toJpa(aiModel);
        AiModelJpaEntity saved = aiModelJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<AiModel> findById(AiModelId id) {
        return aiModelJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<AiModel> findAll() {
        return aiModelJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(AiModel aiModel) {
        aiModelJpaRepository.deleteById(aiModel.id().value());
    }
}
