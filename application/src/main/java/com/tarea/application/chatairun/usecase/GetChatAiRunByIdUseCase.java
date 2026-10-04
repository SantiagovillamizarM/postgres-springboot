package com.tarea.application.chatairun.usecase;

import com.tarea.application.chatairun.dto.ChatAiRunResponse;
import com.tarea.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;

public class GetChatAiRunByIdUseCase {

    private final ChatAiRunRepository chatAiRunRepository;

    public GetChatAiRunByIdUseCase(ChatAiRunRepository chatAiRunRepository) {
        this.chatAiRunRepository = chatAiRunRepository;
    }

    public ChatAiRunResponse execute(ChatAiRunId id) {
        var chatAiRun = chatAiRunRepository.findById(id)
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(id.value().toString()));

        return new ChatAiRunResponse(
            chatAiRun.id().value(),
            chatAiRun.conversationId().value(),
            chatAiRun.messageId().value(),
            chatAiRun.modelId().value(),
            chatAiRun.aiRunStatusId().value(),
            chatAiRun.createdAt(),
            chatAiRun.updatedAt()
        );
    }
}
