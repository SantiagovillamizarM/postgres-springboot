package com.tarea.application.chatairunerror.usecase;

import com.tarea.application.chatairunerror.command.UpdateChatAiRunErrorCommand;
import com.tarea.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.tarea.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.tarea.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class UpdateChatAiRunErrorUseCase {

    private final ChatAiRunErrorRepository chatAiRunErrorRepository;

    public UpdateChatAiRunErrorUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        this.chatAiRunErrorRepository = chatAiRunErrorRepository;
    }

    public ChatAiRunErrorResponse execute(UpdateChatAiRunErrorCommand command) {
        var chatAiRunError = chatAiRunErrorRepository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(command.id().value().toString()));

        chatAiRunError.update(
                command.aiRunId(),
                command.errorMessage(),
                command.errorCode(),
                command.providerErrorId()
        );

        var updated = chatAiRunErrorRepository.save(chatAiRunError);

        return new ChatAiRunErrorResponse(
            updated.id().value(),
            updated.aiRunId().value(),
            updated.errorMessage(),
            updated.errorCode(),
            updated.providerErrorId(),
            updated.createdAt()
        );
    }
}
