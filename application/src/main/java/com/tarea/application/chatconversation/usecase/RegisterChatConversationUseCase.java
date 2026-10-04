package com.tarea.application.chatconversation.usecase;

import com.tarea.application.chatconversation.command.RegisterChatConversationCommand;
import com.tarea.application.chatconversation.dto.ChatConversationResponse;
import com.tarea.domain.chatconversation.model.aggregate.ChatConversation;
import com.tarea.domain.chatconversation.port.repository.ChatConversationRepository;

public class RegisterChatConversationUseCase {

    private final ChatConversationRepository chatConversationRepository;

    public RegisterChatConversationUseCase(ChatConversationRepository chatConversationRepository) {
        this.chatConversationRepository = chatConversationRepository;
    }

    public ChatConversationResponse execute(RegisterChatConversationCommand command) {
        ChatConversation chatConversation = ChatConversation.register(
                command.conversationStatusId(),
                command.priorityId(),
                command.lastMessageAt(),
                command.closed(),
                command.closedAt(),
                command.closedBy()
        );

        ChatConversation saved = chatConversationRepository.save(chatConversation);

        return new ChatConversationResponse(
            saved.id().value(),
            saved.conversationStatusId().value(),
            saved.priorityId().value(),
            saved.lastMessageAt(),
            saved.closed(),
            saved.closedAt(),
            saved.closedBy() != null ? saved.closedBy().value() : null,
            saved.createdAt(),
            saved.updatedAt()
        );
    }
}
