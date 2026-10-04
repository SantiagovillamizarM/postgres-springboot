package com.tarea.infrastructure.conversationstatus.adapters.out.persistence.repositories;

import com.tarea.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.conversationstatus.port.repository.ConversationStatusRepository;
import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.entity.ConversationStatusJpaEntity;
import com.tarea.infrastructure.conversationstatus.adapters.out.persistence.mappers.ConversationStatusPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ConversationStatusRepositoryAdapter implements ConversationStatusRepository {

    private final ConversationStatusJpaRepository conversationStatusJpaRepository;
    private final ConversationStatusPersistenceMapper mapper;

    public ConversationStatusRepositoryAdapter(ConversationStatusJpaRepository conversationStatusJpaRepository, ConversationStatusPersistenceMapper mapper) {
        this.conversationStatusJpaRepository = conversationStatusJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ConversationStatus save(ConversationStatus conversationStatus) {
        ConversationStatusJpaEntity entity = mapper.toJpa(conversationStatus);
        ConversationStatusJpaEntity saved = conversationStatusJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ConversationStatus> findById(ConversationStatusId id) {
        return conversationStatusJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ConversationStatus> findAll() {
        return conversationStatusJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ConversationStatus conversationStatus) {
        conversationStatusJpaRepository.deleteById(conversationStatus.id().value());
    }
}
