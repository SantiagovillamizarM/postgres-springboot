package com.tarea.infrastructure.professional.adapters.out.persistence.repositories;

import com.tarea.domain.professional.model.aggregate.Professional;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.professional.port.repository.ProfessionalRepository;
import com.tarea.infrastructure.professional.adapters.out.persistence.entity.ProfessionalJpaEntity;
import com.tarea.infrastructure.professional.adapters.out.persistence.mappers.ProfessionalPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ProfessionalRepositoryAdapter implements ProfessionalRepository {

    private final ProfessionalJpaRepository professionalJpaRepository;
    private final ProfessionalPersistenceMapper mapper;

    public ProfessionalRepositoryAdapter(ProfessionalJpaRepository professionalJpaRepository, ProfessionalPersistenceMapper mapper) {
        this.professionalJpaRepository = professionalJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Professional save(Professional professional) {
        ProfessionalJpaEntity entity = mapper.toJpa(professional);
        ProfessionalJpaEntity saved = professionalJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<Professional> findById(ProfessionalId id) {
        return professionalJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<Professional> findAll() {
        return professionalJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByDocumentNumber(String documentNumber) {
        return professionalJpaRepository.existsByDocumentNumber(documentNumber);
    }

    @Override
    public void delete(Professional professional) {
        professionalJpaRepository.deleteById(professional.id().value());
    }
}
