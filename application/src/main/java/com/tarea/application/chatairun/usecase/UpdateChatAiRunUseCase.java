package com.tarea.application.chatairun.usecase;

import com.tarea.application.chatairun.command.UpdateChatAiRunCommand;
import com.tarea.application.chatairun.dto.ChatAiRunResponse;
import com.tarea.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;

public class UpdateChatAiRunUseCase {

    private final ChatAiRunRepository chatAiRunRepository;

    public UpdateChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        this.chatAiRunRepository = chatAiRunRepository;
    }

    public ChatAiRunResponse execute(UpdateChatAiRunCommand command) {
        var chatAiRun = chatAiRunRepository.findById(command.id())
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(command.id().value().toString()));

        chatAiRun.update(
                command.conversationId(),
                command.messageId(),
                command.modelId(),
                command.aiRunStatusId()
        );

        var updated = chatAiRunRepository.save(chatAiRun);

        return new ChatAiRunResponse(
            updated.id().value(),
            updated.conversationId().value(),
            updated.messageId().value(),
            updated.modelId().value(),
            updated.aiRunStatusId().value(),
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
