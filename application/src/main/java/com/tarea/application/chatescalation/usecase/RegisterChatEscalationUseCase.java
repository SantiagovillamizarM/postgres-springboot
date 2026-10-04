package com.tarea.application.chatescalation.usecase;

import com.tarea.application.chatescalation.command.RegisterChatEscalationCommand;
import com.tarea.application.chatescalation.dto.ChatEscalationResponse;
import com.tarea.domain.chatescalation.model.aggregate.ChatEscalation;
import com.tarea.domain.chatescalation.port.repository.ChatEscalationRepository;

public class RegisterChatEscalationUseCase {

    private final ChatEscalationRepository chatEscalationRepository;

    public RegisterChatEscalationUseCase(ChatEscalationRepository chatEscalationRepository) {
        this.chatEscalationRepository = chatEscalationRepository;
    }

    public ChatEscalationResponse execute(RegisterChatEscalationCommand command) {
        ChatEscalation chatEscalation = ChatEscalation.register(
                command.conversationId(),
                command.statusId(),
                command.fromAi(),
                command.reason()
        );

        ChatEscalation saved = chatEscalationRepository.save(chatEscalation);

        return new ChatEscalationResponse(
            saved.id().value(),
            saved.conversationId().value(),
            saved.statusId().value(),
            saved.fromAi(),
            saved.reason(),
            saved.createdAt()
        );
    }
}
