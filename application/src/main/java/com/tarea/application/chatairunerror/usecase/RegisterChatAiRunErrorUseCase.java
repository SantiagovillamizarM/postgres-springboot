package com.tarea.application.chatairunerror.usecase;

import com.tarea.application.chatairunerror.command.RegisterChatAiRunErrorCommand;
import com.tarea.application.chatairunerror.dto.ChatAiRunErrorResponse;
import com.tarea.domain.chatairunerror.model.aggregate.ChatAiRunError;
import com.tarea.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class RegisterChatAiRunErrorUseCase {

    private final ChatAiRunErrorRepository chatAiRunErrorRepository;

    public RegisterChatAiRunErrorUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        this.chatAiRunErrorRepository = chatAiRunErrorRepository;
    }

    public ChatAiRunErrorResponse execute(RegisterChatAiRunErrorCommand command) {
        ChatAiRunError chatAiRunError = ChatAiRunError.register(
                command.aiRunId(),
                command.errorMessage(),
                command.errorCode(),
                command.providerErrorId()
        );

        ChatAiRunError saved = chatAiRunErrorRepository.save(chatAiRunError);

        return new ChatAiRunErrorResponse(
            saved.id().value(),
            saved.aiRunId().value(),
            saved.errorMessage(),
            saved.errorCode(),
            saved.providerErrorId(),
            saved.createdAt()
        );
    }
}
