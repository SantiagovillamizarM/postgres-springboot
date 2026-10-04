package com.tarea.infrastructure.encounterstatus.adapters.out.persistence.repositories;

import com.tarea.domain.encounterstatus.model.aggregate.EncounterStatus;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;
import com.tarea.domain.encounterstatus.port.repository.EncounterStatusRepository;
import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.entity.EncounterStatusJpaEntity;
import com.tarea.infrastructure.encounterstatus.adapters.out.persistence.mappers.EncounterStatusPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class EncounterStatusRepositoryAdapter implements EncounterStatusRepository {

    private final EncounterStatusJpaRepository encounterStatusJpaRepository;
    private final EncounterStatusPersistenceMapper mapper;

    public EncounterStatusRepositoryAdapter(EncounterStatusJpaRepository encounterStatusJpaRepository, EncounterStatusPersistenceMapper mapper) {
        this.encounterStatusJpaRepository = encounterStatusJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public EncounterStatus save(EncounterStatus encounterStatus) {
        EncounterStatusJpaEntity entity = mapper.toJpa(encounterStatus);
        EncounterStatusJpaEntity saved = encounterStatusJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<EncounterStatus> findById(EncounterStatusId id) {
        return encounterStatusJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<EncounterStatus> findAll() {
        return encounterStatusJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return encounterStatusJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(EncounterStatus encounterStatus) {
        encounterStatusJpaRepository.deleteById(encounterStatus.id().value());
    }
}
