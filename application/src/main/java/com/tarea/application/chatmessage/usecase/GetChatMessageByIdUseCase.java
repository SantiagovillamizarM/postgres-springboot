package com.tarea.application.chatmessage.usecase;

import com.tarea.application.chatmessage.dto.ChatMessageResponse;
import com.tarea.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatmessage.port.repository.ChatMessageRepository;

public class GetChatMessageByIdUseCase {

    private final ChatMessageRepository chatMessageRepository;

    public GetChatMessageByIdUseCase(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public ChatMessageResponse execute(ChatMessageId id) {
        var chatMessage = chatMessageRepository.findById(id)
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(id.value().toString()));

        return new ChatMessageResponse(
            chatMessage.id().value(),
            chatMessage.conversationId().value(),
            chatMessage.messageTypeId().value(),
            chatMessage.participantId().value(),
            chatMessage.content(),
            chatMessage.metadata(),
            chatMessage.createdAt()
        );
    }
}
