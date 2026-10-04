package com.tarea.application.chatairunmetric.usecase;

import com.tarea.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

import java.util.List;

public class ListChatAiRunMetricUseCase {

    private final ChatAiRunMetricRepository chatAiRunMetricRepository;

    public ListChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        this.chatAiRunMetricRepository = chatAiRunMetricRepository;
    }

    public List<ChatAiRunMetricResponse> execute() {
        return chatAiRunMetricRepository.findAll().stream()
                .map(chatAiRunMetric -> new ChatAiRunMetricResponse(
                    chatAiRunMetric.id().value(),
                    chatAiRunMetric.aiRunId().value(),
                    chatAiRunMetric.promptTokens(),
                    chatAiRunMetric.completionTokens(),
                    chatAiRunMetric.totalTokens(),
                    chatAiRunMetric.cost(),
                    chatAiRunMetric.createdAt()
                ))
                .toList();
    }
}
