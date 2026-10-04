package com.tarea.domain.chatairunmetric.port.repository;

import com.tarea.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;

import java.util.List;
import java.util.Optional;

public interface ChatAiRunMetricRepository {
    ChatAiRunMetric save(ChatAiRunMetric chatAiRunMetric);
    Optional<ChatAiRunMetric> findById(ChatAiRunMetricId id);
    List<ChatAiRunMetric> findAll();
    void delete(ChatAiRunMetric chatAiRunMetric);
}
