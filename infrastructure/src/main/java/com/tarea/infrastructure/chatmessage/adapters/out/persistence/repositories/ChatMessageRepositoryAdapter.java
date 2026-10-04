package com.tarea.infrastructure.chatmessage.adapters.out.persistence.repositories;

import com.tarea.domain.chatmessage.model.aggregate.ChatMessage;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatmessage.port.repository.ChatMessageRepository;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.entity.ChatMessageJpaEntity;
import com.tarea.infrastructure.chatmessage.adapters.out.persistence.mappers.ChatMessagePersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatMessageRepositoryAdapter implements ChatMessageRepository {

    private final ChatMessageJpaRepository chatMessageJpaRepository;
    private final ChatMessagePersistenceMapper mapper;

    public ChatMessageRepositoryAdapter(ChatMessageJpaRepository chatMessageJpaRepository, ChatMessagePersistenceMapper mapper) {
        this.chatMessageJpaRepository = chatMessageJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        ChatMessageJpaEntity entity = mapper.toJpa(chatMessage);
        ChatMessageJpaEntity saved = chatMessageJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatMessage> findById(ChatMessageId id) {
        return chatMessageJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ChatMessage> findAll() {
        return chatMessageJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ChatMessage chatMessage) {
        chatMessageJpaRepository.deleteById(chatMessage.id().value());
    }
}
