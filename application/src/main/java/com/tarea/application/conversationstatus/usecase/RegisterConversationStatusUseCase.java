package com.tarea.application.conversationstatus.usecase;

import com.tarea.application.conversationstatus.command.RegisterConversationStatusCommand;
import com.tarea.application.conversationstatus.dto.ConversationStatusResponse;
import com.tarea.domain.conversationstatus.model.aggregate.ConversationStatus;
import com.tarea.domain.conversationstatus.port.repository.ConversationStatusRepository;

public class RegisterConversationStatusUseCase {

    private final ConversationStatusRepository conversationStatusRepository;

    public RegisterConversationStatusUseCase(ConversationStatusRepository conversationStatusRepository) {
        this.conversationStatusRepository = conversationStatusRepository;
    }

    public ConversationStatusResponse execute(RegisterConversationStatusCommand command) {
        ConversationStatus conversationStatus = ConversationStatus.register(
                command.nameStatus()
        );

        ConversationStatus saved = conversationStatusRepository.save(conversationStatus);

        return new ConversationStatusResponse(
            saved.id().value(),
            saved.nameStatus(),
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
