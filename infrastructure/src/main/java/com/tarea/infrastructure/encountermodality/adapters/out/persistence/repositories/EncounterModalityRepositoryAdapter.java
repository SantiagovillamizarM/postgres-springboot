package com.tarea.infrastructure.encountermodality.adapters.out.persistence.repositories;

import com.tarea.domain.encountermodality.model.aggregate.EncounterModality;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;
import com.tarea.domain.encountermodality.port.repository.EncounterModalityRepository;
import com.tarea.infrastructure.encountermodality.adapters.out.persistence.entity.EncounterModalityJpaEntity;
import com.tarea.infrastructure.encountermodality.adapters.out.persistence.mappers.EncounterModalityPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class EncounterModalityRepositoryAdapter implements EncounterModalityRepository {

    private final EncounterModalityJpaRepository encounterModalityJpaRepository;
    private final EncounterModalityPersistenceMapper mapper;

    public EncounterModalityRepositoryAdapter(EncounterModalityJpaRepository encounterModalityJpaRepository, EncounterModalityPersistenceMapper mapper) {
        this.encounterModalityJpaRepository = encounterModalityJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EncounterModality save(EncounterModality encounterModality) {
        EncounterModalityJpaEntity entity = mapper.toJpa(encounterModality);
        EncounterModalityJpaEntity saved = encounterModalityJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterModality> findById(EncounterModalityId id) {
        return encounterModalityJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<EncounterModality> findAll() {
        return encounterModalityJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return encounterModalityJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(EncounterModality encounterModality) {
        encounterModalityJpaRepository.deleteById(encounterModality.id().value());
    }
}
