package com.tarea.application.chatairun.usecase;

import com.tarea.application.chatairun.command.RegisterChatAiRunCommand;
import com.tarea.application.chatairun.dto.ChatAiRunResponse;
import com.tarea.domain.chatairun.model.aggregate.ChatAiRun;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;

public class RegisterChatAiRunUseCase {

    private final ChatAiRunRepository chatAiRunRepository;

    public RegisterChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        this.chatAiRunRepository = chatAiRunRepository;
    }

    public ChatAiRunResponse execute(RegisterChatAiRunCommand command) {
        ChatAiRun chatAiRun = ChatAiRun.register(
                command.conversationId(),
                command.messageId(),
                command.modelId(),
                command.aiRunStatusId()
        );

        ChatAiRun saved = chatAiRunRepository.save(chatAiRun);

        return new ChatAiRunResponse(
            saved.id().value(),
            saved.conversationId().value(),
            saved.messageId().value(),
            saved.modelId().value(),
            saved.aiRunStatusId().value(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
