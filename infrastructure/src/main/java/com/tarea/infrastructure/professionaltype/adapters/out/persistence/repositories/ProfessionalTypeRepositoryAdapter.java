package com.tarea.infrastructure.professionaltype.adapters.out.persistence.repositories;

import com.tarea.domain.professionaltype.model.aggregate.ProfessionalType;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;
import com.tarea.domain.professionaltype.port.repository.ProfessionalTypeRepository;
import com.tarea.infrastructure.professionaltype.adapters.out.persistence.entity.ProfessionalTypeJpaEntity;
import com.tarea.infrastructure.professionaltype.adapters.out.persistence.mappers.ProfessionalTypePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ProfessionalTypeRepositoryAdapter implements ProfessionalTypeRepository {

    private final ProfessionalTypeJpaRepository professionalTypeJpaRepository;
    private final ProfessionalTypePersistenceMapper mapper;

    public ProfessionalTypeRepositoryAdapter(ProfessionalTypeJpaRepository professionalTypeJpaRepository, ProfessionalTypePersistenceMapper mapper) {
        this.professionalTypeJpaRepository = professionalTypeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ProfessionalType save(ProfessionalType professionalType) {
        ProfessionalTypeJpaEntity entity = mapper.toJpa(professionalType);
        ProfessionalTypeJpaEntity saved = professionalTypeJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ProfessionalType> findById(ProfessionalTypeId id) {
        return professionalTypeJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ProfessionalType> findAll() {
        return professionalTypeJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByName(String name) {
        return professionalTypeJpaRepository.existsByName(name);
    }

    @Override
    public void delete(ProfessionalType professionalType) {
        professionalTypeJpaRepository.deleteById(professionalType.id().value());
    }
}
