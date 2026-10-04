package com.tarea.application.conversationstatus.usecase;

import com.tarea.application.conversationstatus.dto.ConversationStatusResponse;
import com.tarea.domain.conversationstatus.port.repository.ConversationStatusRepository;

import java.util.List;

public class ListConversationStatusUseCase {

    private final ConversationStatusRepository conversationStatusRepository;

    public ListConversationStatusUseCase(ConversationStatusRepository conversationStatusRepository) {
        this.conversationStatusRepository = conversationStatusRepository;
    }

    public List<ConversationStatusResponse> execute() {
        return conversationStatusRepository.findAll().stream()
                .map(conversationStatus -> new ConversationStatusResponse(
                    conversationStatus.id().value(),
                    conversationStatus.nameStatus(),
                    conversationStatus.createdAt(),
                    conversationStatus.updatedAt()
                ))
                .toList();
    }
}
