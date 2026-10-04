package com.tarea.infrastructure.relationshiptype.adapters.out.persistence.repositories;

import com.tarea.domain.relationshiptype.model.aggregate.RelationshipType;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;
import com.tarea.domain.relationshiptype.port.repository.RelationshipTypeRepository;
import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.entity.RelationshipTypeJpaEntity;
import com.tarea.infrastructure.relationshiptype.adapters.out.persistence.mappers.RelationshipTypePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class RelationshipTypeRepositoryAdapter implements RelationshipTypeRepository {

    private final RelationshipTypeJpaRepository relationshipTypeJpaRepository;
    private final RelationshipTypePersistenceMapper mapper;

    public RelationshipTypeRepositoryAdapter(RelationshipTypeJpaRepository relationshipTypeJpaRepository, RelationshipTypePersistenceMapper mapper) {
        this.relationshipTypeJpaRepository = relationshipTypeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public RelationshipType save(RelationshipType relationshipType) {
        RelationshipTypeJpaEntity entity = mapper.toJpa(relationshipType);
        RelationshipTypeJpaEntity saved = relationshipTypeJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<RelationshipType> findById(RelationshipTypeId id) {
        return relationshipTypeJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<RelationshipType> findAll() {
        return relationshipTypeJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByDescription(String description) {
        return relationshipTypeJpaRepository.existsByDescription(description);
    }

    @Override
    public void delete(RelationshipType relationshipType) {
        relationshipTypeJpaRepository.deleteById(relationshipType.id().value());
    }
}
