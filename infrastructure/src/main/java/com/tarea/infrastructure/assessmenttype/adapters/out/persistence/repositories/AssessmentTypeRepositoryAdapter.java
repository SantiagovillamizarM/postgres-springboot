package com.tarea.infrastructure.assessmenttype.adapters.out.persistence.repositories;

import com.tarea.domain.assessmenttype.model.aggregate.AssessmentType;
import com.tarea.domain.assessmenttype.model.valueobject.AssessmentTypeId;
import com.tarea.domain.assessmenttype.port.repository.AssessmentTypeRepository;
import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.entity.AssessmentTypeJpaEntity;
import com.tarea.infrastructure.assessmenttype.adapters.out.persistence.mappers.AssessmentTypePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class AssessmentTypeRepositoryAdapter implements AssessmentTypeRepository {

    private final AssessmentTypeJpaRepository assessmentTypeJpaRepository;
    private final AssessmentTypePersistenceMapper mapper;

    public AssessmentTypeRepositoryAdapter(AssessmentTypeJpaRepository assessmentTypeJpaRepository, AssessmentTypePersistenceMapper mapper) {
        this.assessmentTypeJpaRepository = assessmentTypeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public AssessmentType save(AssessmentType assessmentType) {
        AssessmentTypeJpaEntity entity = mapper.toJpa(assessmentType);
        AssessmentTypeJpaEntity saved = assessmentTypeJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<AssessmentType> findById(AssessmentTypeId id) {
        return assessmentTypeJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<AssessmentType> findAll() {
        return assessmentTypeJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return assessmentTypeJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(AssessmentType assessmentType) {
        assessmentTypeJpaRepository.deleteById(assessmentType.id().value());
    }
}
