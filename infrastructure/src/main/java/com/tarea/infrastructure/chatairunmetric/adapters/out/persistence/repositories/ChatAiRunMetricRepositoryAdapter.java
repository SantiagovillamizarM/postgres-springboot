package com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.repositories;

import com.tarea.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;
import com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.entity.ChatAiRunMetricJpaEntity;
import com.tarea.infrastructure.chatairunmetric.adapters.out.persistence.mappers.ChatAiRunMetricPersistenceMapper;

import java.util.List;
import java.util.Optional;

public class ChatAiRunMetricRepositoryAdapter implements ChatAiRunMetricRepository {

    private final ChatAiRunMetricJpaRepository chatAiRunMetricJpaRepository;
    private final ChatAiRunMetricPersistenceMapper mapper;

    public ChatAiRunMetricRepositoryAdapter(ChatAiRunMetricJpaRepository chatAiRunMetricJpaRepository, ChatAiRunMetricPersistenceMapper mapper) {
        this.chatAiRunMetricJpaRepository = chatAiRunMetricJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public ChatAiRunMetric save(ChatAiRunMetric chatAiRunMetric) {
        ChatAiRunMetricJpaEntity entity = mapper.toJpa(chatAiRunMetric);
        ChatAiRunMetricJpaEntity saved = chatAiRunMetricJpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<ChatAiRunMetric> findById(ChatAiRunMetricId id) {
        return chatAiRunMetricJpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public List<ChatAiRunMetric> findAll() {
        return chatAiRunMetricJpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ChatAiRunMetric chatAiRunMetric) {
        chatAiRunMetricJpaRepository.deleteById(chatAiRunMetric.id().value());
    }
}
