package com.tarea.infrastructure.consenttype.adapters.out.persistence.repositories;

import com.tarea.domain.consenttype.model.aggregate.ConsentType;
import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;
import com.tarea.domain.consenttype.port.repository.ConsentTypeRepository;
import com.tarea.infrastructure.consenttype.adapters.out.persistence.entity.ConsentTypeJpaEntity;
import com.tarea.infrastructure.consenttype.adapters.out.persistence.mappers.ConsentTypePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ConsentTypeRepositoryAdapter implements ConsentTypeRepository {

    private final ConsentTypeJpaRepository consentTypeJpaRepository;
    private final ConsentTypePersistenceMapper mapper;

    public ConsentTypeRepositoryAdapter(ConsentTypeJpaRepository consentTypeJpaRepository, ConsentTypePersistenceMapper mapper) {
        this.consentTypeJpaRepository = consentTypeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ConsentType save(ConsentType consentType) {
        ConsentTypeJpaEntity entity = mapper.toJpa(consentType);
        ConsentTypeJpaEntity saved = consentTypeJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ConsentType> findById(ConsentTypeId id) {
        return consentTypeJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ConsentType> findAll() {
        return consentTypeJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCode(String code) {
        return consentTypeJpaRepository.existsByCode(code);
    }

    @Override
    public void delete(ConsentType consentType) {
        consentTypeJpaRepository.deleteById(consentType.id().value());
    }
}
