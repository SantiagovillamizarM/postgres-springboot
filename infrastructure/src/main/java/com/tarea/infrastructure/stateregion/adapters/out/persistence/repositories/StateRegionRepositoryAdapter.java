package com.tarea.infrastructure.stateregion.adapters.out.persistence.repositories;

import com.tarea.domain.stateregion.model.aggregate.StateRegion;
import com.tarea.domain.stateregion.model.valueobject.StateRegionId;
import com.tarea.domain.stateregion.port.repository.StateRegionRepository;
import com.tarea.infrastructure.stateregion.adapters.out.persistence.entity.StateRegionJpaEntity;
import com.tarea.infrastructure.stateregion.adapters.out.persistence.mappers.StateRegionPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class StateRegionRepositoryAdapter implements StateRegionRepository {

    private final StateRegionJpaRepository stateRegionJpaRepository;
    private final StateRegionPersistenceMapper mapper;

    public StateRegionRepositoryAdapter(StateRegionJpaRepository stateRegionJpaRepository, StateRegionPersistenceMapper mapper) {
        this.stateRegionJpaRepository = stateRegionJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public StateRegion save(StateRegion stateRegion) {
        StateRegionJpaEntity entity = mapper.toJpa(stateRegion);
        StateRegionJpaEntity saved = stateRegionJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<StateRegion> findById(StateRegionId id) {
        return stateRegionJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<StateRegion> findAll() {
        return stateRegionJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(StateRegion stateRegion) {
        stateRegionJpaRepository.deleteById(stateRegion.id().value());
    }
}
