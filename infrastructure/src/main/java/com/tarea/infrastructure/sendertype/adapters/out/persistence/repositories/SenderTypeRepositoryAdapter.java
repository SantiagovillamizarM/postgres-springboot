package com.tarea.infrastructure.sendertype.adapters.out.persistence.repositories;

import com.tarea.domain.sendertype.model.aggregate.SenderType;
import com.tarea.domain.sendertype.model.valueobject.SenderTypeId;
import com.tarea.domain.sendertype.port.repository.SenderTypeRepository;
import com.tarea.infrastructure.sendertype.adapters.out.persistence.entity.SenderTypeJpaEntity;
import com.tarea.infrastructure.sendertype.adapters.out.persistence.mappers.SenderTypePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class SenderTypeRepositoryAdapter implements SenderTypeRepository {

    private final SenderTypeJpaRepository senderTypeJpaRepository;
    private final SenderTypePersistenceMapper mapper;

    public SenderTypeRepositoryAdapter(SenderTypeJpaRepository senderTypeJpaRepository, SenderTypePersistenceMapper mapper) {
        this.senderTypeJpaRepository = senderTypeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public SenderType save(SenderType senderType) {
        SenderTypeJpaEntity entity = mapper.toJpa(senderType);
        SenderTypeJpaEntity saved = senderTypeJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<SenderType> findById(SenderTypeId id) {
        return senderTypeJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<SenderType> findAll() {
        return senderTypeJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(SenderType senderType) {
        senderTypeJpaRepository.deleteById(senderType.id().value());
    }
}
