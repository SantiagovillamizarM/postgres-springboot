package com.tarea.application.chatmessage.usecase;

import com.tarea.application.chatmessage.command.UpdateChatMessageCommand;
import com.tarea.application.chatmessage.dto.ChatMessageResponse;
import com.tarea.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.tarea.domain.chatmessage.port.repository.ChatMessageRepository;

public class UpdateChatMessageUseCase {

    private final ChatMessageRepository chatMessageRepository;

    public UpdateChatMessageUseCase(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessageResponse execute(UpdateChatMessageCommand command) {
        var chatMessage = chatMessageRepository.findById(command.id())
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(command.id().value().toString()));

        chatMessage.update(
                command.conversationId(),
                command.messageTypeId(),
                command.participantId(),
                command.content(),
                command.metadata()
        );

        var updated = chatMessageRepository.save(chatMessage);

        return new ChatMessageResponse(
            updated.id().value(),
            updated.conversationId().value(),
            updated.messageTypeId().value(),
            updated.participantId().value(),
            updated.content(),
            updated.metadata(),
            updated.createdAt()
        );
    }
}
