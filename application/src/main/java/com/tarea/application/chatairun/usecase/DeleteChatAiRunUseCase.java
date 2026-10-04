package com.tarea.application.chatairun.usecase;

import com.tarea.application.chatairun.exception.ChatAiRunNotFoundApplicationException;
import com.tarea.domain.chatairun.model.valueobject.ChatAiRunId;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;

public class DeleteChatAiRunUseCase {

    private final ChatAiRunRepository chatAiRunRepository;

    public DeleteChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        this.chatAiRunRepository = chatAiRunRepository;
    }

    public void execute(ChatAiRunId id) {
        var chatAiRun = chatAiRunRepository.findById(id)
                .orElseThrow(() -> new ChatAiRunNotFoundApplicationException(id.value().toString()));

        chatAiRun.markAsDeleted();
        chatAiRunRepository.delete(chatAiRun);
    }
}
