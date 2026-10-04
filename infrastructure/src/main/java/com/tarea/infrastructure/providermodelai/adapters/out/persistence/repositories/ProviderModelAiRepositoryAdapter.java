package com.tarea.infrastructure.providermodelai.adapters.out.persistence.repositories;

import com.tarea.domain.providermodelai.model.aggregate.ProviderModelAi;
import com.tarea.domain.providermodelai.model.valueobject.ProviderModelAiId;
import com.tarea.domain.providermodelai.port.repository.ProviderModelAiRepository;
import com.tarea.infrastructure.providermodelai.adapters.out.persistence.entity.ProviderModelAiJpaEntity;
import com.tarea.infrastructure.providermodelai.adapters.out.persistence.mappers.ProviderModelAiPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ProviderModelAiRepositoryAdapter implements ProviderModelAiRepository {

    private final ProviderModelAiJpaRepository providerModelAiJpaRepository;
    private final ProviderModelAiPersistenceMapper mapper;

    public ProviderModelAiRepositoryAdapter(ProviderModelAiJpaRepository providerModelAiJpaRepository, ProviderModelAiPersistenceMapper mapper) {
        this.providerModelAiJpaRepository = providerModelAiJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ProviderModelAi save(ProviderModelAi providerModelAi) {
        ProviderModelAiJpaEntity entity = mapper.toJpa(providerModelAi);
        ProviderModelAiJpaEntity saved = providerModelAiJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProviderModelAi> findById(ProviderModelAiId id) {
        return providerModelAiJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ProviderModelAi> findAll() {
        return providerModelAiJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ProviderModelAi providerModelAi) {
        providerModelAiJpaRepository.deleteById(providerModelAi.id().value());
    }
}
