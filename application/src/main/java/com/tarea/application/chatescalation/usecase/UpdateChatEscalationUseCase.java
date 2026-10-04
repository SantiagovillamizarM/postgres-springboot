package com.tarea.application.chatescalation.usecase;

import com.tarea.application.chatescalation.command.UpdateChatEscalationCommand;
import com.tarea.application.chatescalation.dto.ChatEscalationResponse;
import com.tarea.application.chatescalation.exception.ChatEscalationNotFoundApplicationException;
import com.tarea.domain.chatescalation.port.repository.ChatEscalationRepository;

public class UpdateChatEscalationUseCase {

    private final ChatEscalationRepository chatEscalationRepository;

    public UpdateChatEscalationUseCase(ChatEscalationRepository chatEscalationRepository) {
        this.chatEscalationRepository = chatEscalationRepository;
    }

    public ChatEscalationResponse execute(UpdateChatEscalationCommand command) {
        var chatEscalation = chatEscalationRepository.findById(command.id())
                .orElseThrow(() -> new ChatEscalationNotFoundApplicationException(command.id().value().toString()));

        chatEscalation.update(
                command.conversationId(),
                command.statusId(),
                command.fromAi(),
                command.reason()
        );

        var updated = chatEscalationRepository.save(chatEscalation);

        return new ChatEscalationResponse(
            updated.id().value(),
            updated.conversationId().value(),
            updated.statusId().value(),
            updated.fromAi(),
            updated.reason(),
            updated.createdAt()
        );
    }
}
