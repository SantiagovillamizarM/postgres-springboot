package com.tarea.infrastructure.encountertype.adapters.out.persistence.repositories;

import com.tarea.domain.encountertype.model.aggregate.EncounterType;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;
import com.tarea.domain.encountertype.port.repository.EncounterTypeRepository;
import com.tarea.infrastructure.encountertype.adapters.out.persistence.entity.EncounterTypeJpaEntity;
import com.tarea.infrastructure.encountertype.adapters.out.persistence.mappers.EncounterTypePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class EncounterTypeRepositoryAdapter implements EncounterTypeRepository {

    private final EncounterTypeJpaRepository encounterTypeJpaRepository;
    private final EncounterTypePersistenceMapper mapper;

    public EncounterTypeRepositoryAdapter(EncounterTypeJpaRepository encounterTypeJpaRepository, EncounterTypePersistenceMapper mapper) {
        this.encounterTypeJpaRepository = encounterTypeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EncounterType save(EncounterType encounterType) {
        EncounterTypeJpaEntity entity = mapper.toJpa(encounterType);
        EncounterTypeJpaEntity saved = encounterTypeJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterType> findById(EncounterTypeId id) {
        return encounterTypeJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<EncounterType> findAll() {
        return encounterTypeJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return encounterTypeJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(EncounterType encounterType) {
        encounterTypeJpaRepository.deleteById(encounterType.id().value());
    }
}
