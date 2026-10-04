package com.tarea.application.chatescalationstatushistory.usecase;

import com.tarea.application.chatescalationstatushistory.command.UpdateChatEscalationStatusHistoryCommand;
import com.tarea.application.chatescalationstatushistory.dto.ChatEscalationStatusHistoryResponse;
import com.tarea.application.chatescalationstatushistory.exception.ChatEscalationStatusHistoryNotFoundApplicationException;
import com.tarea.domain.chatescalationstatushistory.port.repository.ChatEscalationStatusHistoryRepository;

public class UpdateChatEscalationStatusHistoryUseCase {

    private final ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository;

    public UpdateChatEscalationStatusHistoryUseCase(ChatEscalationStatusHistoryRepository chatEscalationStatusHistoryRepository) {
        this.chatEscalationStatusHistoryRepository = chatEscalationStatusHistoryRepository;
    }

    public ChatEscalationStatusHistoryResponse execute(UpdateChatEscalationStatusHistoryCommand command) {
        var chatEscalationStatusHistory = chatEscalationStatusHistoryRepository.findById(command.id())
                .orElseThrow(() -> new ChatEscalationStatusHistoryNotFoundApplicationException(command.id().value().toString()));

        chatEscalationStatusHistory.update(
                command.escalationId(),
                command.escalationStatusId(),
                command.changedAt()
        );

        var updated = chatEscalationStatusHistoryRepository.save(chatEscalationStatusHistory);

        return new ChatEscalationStatusHistoryResponse(
            updated.id().value(),
            updated.escalationId().value(),
            updated.escalationStatusId().value(),
            updated.changedAt(),
            updated.createdAt()
        );
    }
}
