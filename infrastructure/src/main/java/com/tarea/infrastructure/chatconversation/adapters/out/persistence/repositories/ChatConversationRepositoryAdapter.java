package com.tarea.infrastructure.chatconversation.adapters.out.persistence.repositories;

import com.tarea.domain.chatconversation.model.aggregate.ChatConversation;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversation.port.repository.ChatConversationRepository;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.entity.ChatConversationJpaEntity;
import com.tarea.infrastructure.chatconversation.adapters.out.persistence.mappers.ChatConversationPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatConversationRepositoryAdapter implements ChatConversationRepository {

    private final ChatConversationJpaRepository chatConversationJpaRepository;
    private final ChatConversationPersistenceMapper mapper;

    public ChatConversationRepositoryAdapter(ChatConversationJpaRepository chatConversationJpaRepository, ChatConversationPersistenceMapper mapper) {
        this.chatConversationJpaRepository = chatConversationJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatConversation save(ChatConversation chatConversation) {
        ChatConversationJpaEntity entity = mapper.toJpa(chatConversation);
        ChatConversationJpaEntity saved = chatConversationJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatConversation> findById(ChatConversationId id) {
        return chatConversationJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ChatConversation> findAll() {
        return chatConversationJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ChatConversation chatConversation) {
        chatConversationJpaRepository.deleteById(chatConversation.id().value());
    }
}
