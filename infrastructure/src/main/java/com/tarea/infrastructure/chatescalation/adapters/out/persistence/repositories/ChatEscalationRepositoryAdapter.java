package com.tarea.infrastructure.chatescalation.adapters.out.persistence.repositories;

import com.tarea.domain.chatescalation.model.aggregate.ChatEscalation;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.chatescalation.port.repository.ChatEscalationRepository;
import com.tarea.infrastructure.chatescalation.adapters.out.persistence.entity.ChatEscalationJpaEntity;
import com.tarea.infrastructure.chatescalation.adapters.out.persistence.mappers.ChatEscalationPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatEscalationRepositoryAdapter implements ChatEscalationRepository {

    private final ChatEscalationJpaRepository chatEscalationJpaRepository;
    private final ChatEscalationPersistenceMapper mapper;

    public ChatEscalationRepositoryAdapter(ChatEscalationJpaRepository chatEscalationJpaRepository, ChatEscalationPersistenceMapper mapper) {
        this.chatEscalationJpaRepository = chatEscalationJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatEscalation save(ChatEscalation chatEscalation) {
        ChatEscalationJpaEntity entity = mapper.toJpa(chatEscalation);
        ChatEscalationJpaEntity saved = chatEscalationJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatEscalation> findById(ChatEscalationId id) {
        return chatEscalationJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ChatEscalation> findAll() {
        return chatEscalationJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ChatEscalation chatEscalation) {
        chatEscalationJpaRepository.deleteById(chatEscalation.id().value());
    }
}
