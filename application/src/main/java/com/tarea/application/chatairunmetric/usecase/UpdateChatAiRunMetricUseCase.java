package com.tarea.application.chatairunmetric.usecase;

import com.tarea.application.chatairunmetric.command.UpdateChatAiRunMetricCommand;
import com.tarea.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.tarea.application.chatairunmetric.exception.ChatAiRunMetricNotFoundApplicationException;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class UpdateChatAiRunMetricUseCase {

    private final ChatAiRunMetricRepository chatAiRunMetricRepository;

    public UpdateChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        this.chatAiRunMetricRepository = chatAiRunMetricRepository;
    }

    public ChatAiRunMetricResponse execute(UpdateChatAiRunMetricCommand command) {
        var chatAiRunMetric = chatAiRunMetricRepository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunMetricNotFoundApplicationException(command.id().value().toString()));

        chatAiRunMetric.update(
                command.aiRunId(),
                command.promptTokens(),
                command.completionTokens(),
                command.totalTokens(),
                command.cost()
        );

        var updated = chatAiRunMetricRepository.save(chatAiRunMetric);

        return new ChatAiRunMetricResponse(
            updated.id().value(),
            updated.aiRunId().value(),
            updated.promptTokens(),
            updated.completionTokens(),
            updated.totalTokens(),
            updated.cost(),
            updated.createdAt()
        );
    }
}
