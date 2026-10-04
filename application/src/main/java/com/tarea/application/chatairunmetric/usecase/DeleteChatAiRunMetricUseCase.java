package com.tarea.application.chatairunmetric.usecase;

import com.tarea.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.tarea.domain.chatairunmetric.model.valueobject.ChatAiRunMetricId;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class DeleteChatAiRunMetricUseCase {

    private final ChatAiRunMetricRepository chatAiRunMetricRepository;

    public DeleteChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        this.chatAiRunMetricRepository = chatAiRunMetricRepository;
    }

    public void execute(ChatAiRunMetricId id) {
        var chatAiRunMetric = chatAiRunMetricRepository.findById(id)
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(id.value().toString()));

        chatAiRunMetric.markAsDeleted();
        chatAiRunMetricRepository.delete(chatAiRunMetric);
    }
}
