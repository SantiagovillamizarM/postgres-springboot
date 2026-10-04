package com.tarea.application.chatairunerror.usecase;

import com.tarea.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.tarea.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.tarea.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class GetChatAiRunErrorByIdUseCase {

    private final ChatAiRunErrorRepository chatAiRunErrorRepository;

    public GetChatAiRunErrorByIdUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        this.chatAiRunErrorRepository = chatAiRunErrorRepository;
    }

    public ChatAiRunErrorResponse execute(ChatAiRunErrorId id) {
        var chatAiRunError = chatAiRunErrorRepository.findById(id)
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(id.value().toString()));

        return new ChatAiRunErrorResponse(
            chatAiRunError.id().value(),
            chatAiRunError.aiRunId().value(),
            chatAiRunError.errorMessage(),
            chatAiRunError.errorCode(),
            chatAiRunError.providerErrorId(),
            chatAiRunError.createdAt()
        );
    }
}
