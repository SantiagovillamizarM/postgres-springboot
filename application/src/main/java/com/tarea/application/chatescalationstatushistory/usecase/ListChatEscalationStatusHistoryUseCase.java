package com.tarea.application.chatescalationstatushistory.usecase;

import com.tarea.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.tarea.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

import java.util.List;

public class ListChatEscalationStatusHistoryUseCase {

    private final ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository;

    public ListChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        this.chatEscalationStatusHistoryRepository = chatEscalationStatusHistoryRepository;
    }

    public List<ChatEscalationStatusHistoryResponse> execute() {
        return chatEscalationStatusHistoryRepository.findAll().stream()
                .map(chatEscalationStatusHistory -> new ChatEscalationStatusHistoryResponse(
                    chatEscalationStatusHistory.id().value(),
                    chatEscalationStatusHistory.escalationId().value(),
                    chatEscalationStatusHistory.escalationStatusId().value(),
                    chatEscalationStatusHistory.changedAt(),
                    chatEscalationStatusHistory.createdAt()
                ))
                .toList();
    }
}
