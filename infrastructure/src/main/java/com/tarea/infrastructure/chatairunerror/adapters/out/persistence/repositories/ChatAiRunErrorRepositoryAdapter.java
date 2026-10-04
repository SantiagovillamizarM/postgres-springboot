package com.tarea.infrastructure.chatairunerror.adapters.out.persistence.repositories;

import com.tarea.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.tarea.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;
import com.tarea.infrastructure.chatairunerror.adapters.out.persistence.entity.ChatAiRunErrorJpaEntity;
import com.tarea.infrastructure.chatairunerror.adapters.out.persistence.mappers.ChatAiRunErrorPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatAiRunErrorRepositoryAdapter implements ChatAiRunErrorRepository {

    private final ChatAiRunErrorJpaRepository chatAiRunErrorJpaRepository;
    private final ChatAiRunErrorPersistenceMapper mapper;

    public ChatAiRunErrorRepositoryAdapter(ChatAiRunErrorJpaRepository chatAiRunErrorJpaRepository, ChatAiRunErrorPersistenceMapper mapper) {
        this.chatAiRunErrorJpaRepository = chatAiRunErrorJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiRunError save(ChatAiRunError chatAiRunError) {
        ChatAiRunErrorJpaEntity entity = mapper.toJpa(chatAiRunError);
        ChatAiRunErrorJpaEntity saved = chatAiRunErrorJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiRunError> findById(ChatAiRunErrorId id) {
        return chatAiRunErrorJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ChatAiRunError> findAll() {
        return chatAiRunErrorJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ChatAiRunError chatAiRunError) {
        chatAiRunErrorJpaRepository.deleteById(chatAiRunError.id().value());
    }
}
