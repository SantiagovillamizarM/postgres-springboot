package com.tarea.infrastructure.gender.adapters.out.persistence.repositories;

import com.tarea.domain.gender.model.aggregate.Gender;
import com.tarea.domain.gender.model.valueobject.GenderId;
import com.tarea.domain.gender.port.repository.GenderRepository;
import com.tarea.infrastructure.gender.adapters.out.persistence.entity.GenderJpaEntity;
import com.tarea.infrastructure.gender.adapters.out.persistence.mappers.GenderPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class GenderRepositoryAdapter implements GenderRepository {

    private final GenderJpaRepository genderJpaRepository;
    private final GenderPersistenceMapper mapper;

    public GenderRepositoryAdapter(GenderJpaRepository genderJpaRepository, GenderPersistenceMapper mapper) {
        this.genderJpaRepository = genderJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Gender save(Gender gender) {
        GenderJpaEntity entity = mapper.toJpa(gender);
        GenderJpaEntity saved = genderJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Gender> findById(GenderId id) {
        return genderJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Gender> findAll() {
        return genderJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByDescription(String description) {
        return genderJpaRepository.existsByDescription(description);
    }

    @Override
    public void delete(Gender gender) {
        genderJpaRepository.deleteById(gender.id().value());
    }
}
