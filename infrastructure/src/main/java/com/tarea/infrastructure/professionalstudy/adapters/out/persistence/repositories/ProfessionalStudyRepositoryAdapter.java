package com.tarea.infrastructure.professionalstudy.adapters.out.persistence.repositories;

import com.tarea.domain.professionalstudy.model.aggregate.ProfessionalStudy;
import com.tarea.domain.professionalstudy.model.valueobject.ProfessionalStudyId;
import com.tarea.domain.professionalstudy.port.repository.ProfessionalStudyRepository;
import com.tarea.infrastructure.professionalstudy.adapters.out.persistence.entity.ProfessionalStudyJpaEntity;
import com.tarea.infrastructure.professionalstudy.adapters.out.persistence.mappers.ProfessionalStudyPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ProfessionalStudyRepositoryAdapter implements ProfessionalStudyRepository {

    private final ProfessionalStudyJpaRepository professionalStudyJpaRepository;
    private final ProfessionalStudyPersistenceMapper mapper;

    public ProfessionalStudyRepositoryAdapter(ProfessionalStudyJpaRepository professionalStudyJpaRepository, ProfessionalStudyPersistenceMapper mapper) {
        this.professionalStudyJpaRepository = professionalStudyJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ProfessionalStudy save(ProfessionalStudy professionalStudy) {
        ProfessionalStudyJpaEntity entity = mapper.toJpa(professionalStudy);
        ProfessionalStudyJpaEntity saved = professionalStudyJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProfessionalStudy> findById(ProfessionalStudyId id) {
        return professionalStudyJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ProfessionalStudy> findAll() {
        return professionalStudyJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ProfessionalStudy professionalStudy) {
        professionalStudyJpaRepository.deleteById(professionalStudy.id().value());
    }
}
