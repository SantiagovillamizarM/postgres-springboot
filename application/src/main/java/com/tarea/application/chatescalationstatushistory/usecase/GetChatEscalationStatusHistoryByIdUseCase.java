package com.tarea.application.chatescalationstatushistory.usecase;

import com.tarea.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.tarea.application.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundApplicationException;
import com.tarea.domain.chatescalationstatushistory.model.valueobject.ChatEscalationStatusHistoryId;
import com.tarea.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

public class GetChatEscalationStatusHistoryByIdUseCase {

    private final ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository;

    public GetChatEscalationStatusHistoryByIdUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        this.chatEscalationStatusHistoryRepository = chatEscalationStatusHistoryRepository;
    }

    public ChatEscalationStatusHistoryResponse execute(ChatEscalationStatusHistoryId id) {
        var chatEscalationStatusHistory = chatEscalationStatusHistoryRepository.findById(id)
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundApplicationException(id.value().toString()));

        return new ChatEscalationStatusHistoryResponse(
            chatEscalationStatusHistory.id().value(),
            chatEscalationStatusHistory.escalationId().value(),
            chatEscalationStatusHistory.escalationStatusId().value(),
            chatEscalationStatusHistory.changedAt(),
            chatEscalationStatusHistory.createdAt()
        );
    }
}
