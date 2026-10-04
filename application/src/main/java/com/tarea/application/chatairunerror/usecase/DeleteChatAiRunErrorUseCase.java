package com.tarea.application.chatairunerror.usecase;

import com.tarea.application.chatairunerror.exception.ChatAiRunErrorNotFoundApplicationException;
import com.tarea.domain.chatairunerror.model.valueobject.ChatAiRunErrorId;
import com.tarea.domain.chatairunerror.port.repository.ChatAiRunErrorRepository;

public class DeleteChatAiRunErrorUseCase {

    private final ChatAiRunErrorRepository chatAiRunErrorRepository;

    public DeleteChatAiRunErrorUseCase(ChatAiRunErrorRepository chatAiRunErrorRepository) {
        this.chatAiRunErrorRepository = chatAiRunErrorRepository;
    }

    public void execute(ChatAiRunErrorId id) {
        var chatAiRunError = chatAiRunErrorRepository.findById(id)
                .orElseThrow(() -> new ChatAiRunErrorNotFoundApplicationException(id.value().toString()));

        chatAiRunError.markAsDeleted();
        chatAiRunErrorRepository.delete(chatAiRunError);
    }
}
