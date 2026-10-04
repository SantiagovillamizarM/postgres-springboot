package com.tarea.application.chatescalation.usecase;

import com.tarea.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.chatescalation.port.repository.ChatEscalationRepository;

public class DeleteChatEscalationUseCase {

    private final ChatEscalationRepository chatEscalationRepository;

    public DeleteChatEscalationUseCase(ChatEscalationRepository chatEscalationRepository) {
        this.chatEscalationRepository = chatEscalationRepository;
    }

    public void execute(ChatEscalationId id) {
        var chatEscalation = chatEscalationRepository.findById(id)
                .orElseThrow(() -> new ChatEscalationNotFoundApplicationException(id.value().toString()));

        chatEscalation.markAsDeleted();
        chatEscalationRepository.delete(chatEscalation);
    }
}
