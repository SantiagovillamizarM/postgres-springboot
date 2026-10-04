package com.tarea.infrastructure.priority.adapters.out.persistence.repositories;

import com.tarea.domain.priority.model.aggregate.Priority;
import com.tarea.domain.priority.model.valueobject.PriorityId;
import com.tarea.domain.priority.port.repository.PriorityRepository;
import com.tarea.infrastructure.priority.adapters.out.persistence.entity.PriorityJpaEntity;
import com.tarea.infrastructure.priority.adapters.out.persistence.mappers.PriorityPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class PriorityRepositoryAdapter implements PriorityRepository {

    private final PriorityJpaRepository priorityJpaRepository;
    private final PriorityPersistenceMapper mapper;

    public PriorityRepositoryAdapter(PriorityJpaRepository priorityJpaRepository, PriorityPersistenceMapper mapper) {
        this.priorityJpaRepository = priorityJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Priority save(Priority priority) {
        PriorityJpaEntity entity = mapper.toJpa(priority);
        PriorityJpaEntity saved = priorityJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Priority> findById(PriorityId id) {
        return priorityJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Priority> findAll() {
        return priorityJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Priority priority) {
        priorityJpaRepository.deleteById(priority.id().value());
    }
}
