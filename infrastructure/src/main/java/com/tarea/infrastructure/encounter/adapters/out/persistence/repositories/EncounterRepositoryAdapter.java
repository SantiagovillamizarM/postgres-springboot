package com.tarea.infrastructure.encounter.adapters.out.persistence.repositories;

import com.tarea.domain.encounter.model.aggregate.Encounter;
import com.tarea.domain.encounter.model.valueobject.EncounterId;
import com.tarea.domain.encounter.port.repository.EncounterRepository;
import com.tarea.infrastructure.encounter.adapters.out.persistence.entity.EncounterJpaEntity;
import com.tarea.infrastructure.encounter.adapters.out.persistence.mappers.EncounterPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class EncounterRepositoryAdapter implements EncounterRepository {

    private final EncounterJpaRepository encounterJpaRepository;
    private final EncounterPersistenceMapper mapper;

    public EncounterRepositoryAdapter(EncounterJpaRepository encounterJpaRepository, EncounterPersistenceMapper mapper) {
        this.encounterJpaRepository = encounterJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Encounter save(Encounter encounter) {
        EncounterJpaEntity entity = mapper.toJpa(encounter);
        EncounterJpaEntity saved = encounterJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Encounter> findById(EncounterId id) {
        return encounterJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Encounter> findAll() {
        return encounterJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Encounter encounter) {
        encounterJpaRepository.deleteById(encounter.id().value());
    }
}
