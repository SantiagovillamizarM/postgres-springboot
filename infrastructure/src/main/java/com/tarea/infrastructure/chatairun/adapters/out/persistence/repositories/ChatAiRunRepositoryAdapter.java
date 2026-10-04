package com.tarea.infrastructure.chatairun.adapters.out.persistence.repositories;

import com.tarea.domain.chatairun.model.aggregate.ChatAiRun;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;
import com.tarea.infrastructure.chatairun.adapters.out.persistence.entity.ChatAiRunJpaEntity;
import com.tarea.infrastructure.chatairun.adapters.out.persistence.mappers.ChatAiRunPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatAiRunRepositoryAdapter implements ChatAiRunRepository {

    private final ChatAiRunJpaRepository chatAiRunJpaRepository;
    private final ChatAiRunPersistenceMapper mapper;

    public ChatAiRunRepositoryAdapter(ChatAiRunJpaRepository chatAiRunJpaRepository, ChatAiRunPersistenceMapper mapper) {
        this.chatAiRunJpaRepository = chatAiRunJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiRun save(ChatAiRun chatAiRun) {
        ChatAiRunJpaEntity entity = mapper.toJpa(chatAiRun);
        ChatAiRunJpaEntity saved = chatAiRunJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiRun> findById(ChatAiRunId id) {
        return chatAiRunJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ChatAiRun> findAll() {
        return chatAiRunJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ChatAiRun chatAiRun) {
        chatAiRunJpaRepository.deleteById(chatAiRun.id().value());
    }
}
