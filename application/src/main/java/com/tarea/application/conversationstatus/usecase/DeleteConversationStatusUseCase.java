package com.tarea.application.conversationstatus.usecase;

import com.tarea.application.conversationstatus.exception.ConversationStatusNotFoundApplicationException;
import com.tarea.domain.conversationstatus.model.valueobject.ConversationStatusId;
import com.tarea.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class DeleteConversationStatusUseCase {

    private final ConversationStatusRepository conversationStatusRepository;

    public DeleteConversationStatusUseCase(ConversationStatusRepository conversationStatusRepository) {
        this.conversationStatusRepository = conversationStatusRepository;
    }

    public void execute(ConversationStatusId id) {
        var conversationStatus = conversationStatusRepository.findById(id)
                .orElseThrow(() -> new ConversationStatusNotFoundApplicationException(id.value().toString()));

        conversationStatus.markAsDeleted();
        conversationStatusRepository.delete(conversationStatus);
    }
}
