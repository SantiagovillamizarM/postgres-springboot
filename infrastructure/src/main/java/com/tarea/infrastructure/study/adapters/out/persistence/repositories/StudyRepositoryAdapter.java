package com.tarea.infrastructure.study.adapters.out.persistence.repositories;

import com.tarea.domain.study.model.aggregate.Study;
import com.tarea.domain.study.model.valueobject.StudyId;
import com.tarea.domain.study.port.repository.StudyRepository;
import com.tarea.infrastructure.study.adapters.out.persistence.entity.StudyJpaEntity;
import com.tarea.infrastructure.study.adapters.out.persistence.mappers.StudyPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class StudyRepositoryAdapter implements StudyRepository {

    private final StudyJpaRepository studyJpaRepository;
    private final StudyPersistenceMapper mapper;

    public StudyRepositoryAdapter(StudyJpaRepository studyJpaRepository, StudyPersistenceMapper mapper) {
        this.studyJpaRepository = studyJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Study save(Study study) {
        StudyJpaEntity entity = mapper.toJpa(study);
        StudyJpaEntity saved = studyJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Study> findById(StudyId id) {
        return studyJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Study> findAll() {
        return studyJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(Study study) {
        studyJpaRepository.deleteById(study.id().value());
    }
}
