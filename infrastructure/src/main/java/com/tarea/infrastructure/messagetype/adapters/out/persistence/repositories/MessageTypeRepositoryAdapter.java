package com.tarea.infrastructure.messagetype.adapters.out.persistence.repositories;

import com.tarea.domain.messagetype.model.aggregate.MessageType;
import com.tarea.domain.messagetype.model.valueobject.MessageTypeId;
import com.tarea.domain.messagetype.port.repository.MessageTypeRepository;
import com.tarea.infrastructure.messagetype.adapters.out.persistence.entity.MessageTypeJpaEntity;
import com.tarea.infrastructure.messagetype.adapters.out.persistence.mappers.MessageTypePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class MessageTypeRepositoryAdapter implements MessageTypeRepository {

    private final MessageTypeJpaRepository messageTypeJpaRepository;
    private final MessageTypePersistenceMapper mapper;

    public MessageTypeRepositoryAdapter(MessageTypeJpaRepository messageTypeJpaRepository, MessageTypePersistenceMapper mapper) {
        this.messageTypeJpaRepository = messageTypeJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public MessageType save(MessageType messageType) {
        MessageTypeJpaEntity entity = mapper.toJpa(messageType);
        MessageTypeJpaEntity saved = messageTypeJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<MessageType> findById(MessageTypeId id) {
        return messageTypeJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<MessageType> findAll() {
        return messageTypeJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(MessageType messageType) {
        messageTypeJpaRepository.deleteById(messageType.id().value());
    }
}
