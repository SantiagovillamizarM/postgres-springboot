package com.tarea.application.chatmessage.usecase;

import com.tarea.application.chatmessage.command.RegisterChatMessageCommand;
import com.tarea.application.chatmessage.dto.ChatMessageResponse;
import com.tarea.domain.chatmessage.model.aggregate.ChatMessage;
import com.tarea.domain.chatmessage.port.repository.ChatMessageRepository;

public class RegisterChatMessageUseCase {

    private final ChatMessageRepository chatMessageRepository;

    public RegisterChatMessageUseCase(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessageResponse execute(RegisterChatMessageCommand command) {
        ChatMessage chatMessage = ChatMessage.register(
                command.conversationId(),
                command.messageTypeId(),
                command.participantId(),
                command.content(),
                command.metadata()
        );

        ChatMessage saved = chatMessageRepository.save(chatMessage);

        return new ChatMessageResponse(
            saved.id().value(),
            saved.conversationId().value(),
            saved.messageTypeId().value(),
            saved.participantId().value(),
            saved.content(),
            saved.metadata(),
            saved.createdAt()
        );
    }
}
