package com.tarea.application.chatairunmetric.usecase;

import com.tarea.application.chatairunmetric.command.RegisterChatAiRunMetricCommand;
import com.tarea.application.chatairunmetric.dto.ChatAiRunMetricResponse;
import com.tarea.domain.chatairunmetric.model.aggregate.ChatAiRunMetric;
import com.tarea.domain.chatairunmetric.port.repository.ChatAiRunMetricRepository;

public class RegisterChatAiRunMetricUseCase {

    private final ChatAiRunMetricRepository chatAiRunMetricRepository;

    public RegisterChatAiRunMetricUseCase(ChatAiRunMetricRepository chatAiRunMetricRepository) {
        this.chatAiRunMetricRepository = chatAiRunMetricRepository;
    }

    public ChatAiRunMetricResponse execute(RegisterChatAiRunMetricCommand command) {
        ChatAiRunMetric chatAiRunMetric = ChatAiRunMetric.register(
                command.aiRunId(),
                command.promptTokens(),
                command.completionTokens(),
                command.totalTokens(),
                command.cost()
        );

        ChatAiRunMetric saved = chatAiRunMetricRepository.save(chatAiRunMetric);

        return new ChatAiRunMetricResponse(
            saved.id().value(),
            saved.aiRunId().value(),
            saved.promptTokens(),
            saved.completionTokens(),
            saved.totalTokens(),
            saved.cost(),
            saved.createdAt()
        );
    }
}
