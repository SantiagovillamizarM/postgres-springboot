package com.tarea.application.chatmessage.usecase;

import com.tarea.application.chatmessage.exception.ChatMessageNotFoundApplicationException;
import com.tarea.domain.chatmessage.model.valueobject.ChatMessageId;
import com.tarea.domain.chatmessage.port.repository.ChatMessageRepository;

public class DeleteChatMessageUseCase {

    private final ChatMessageRepository chatMessageRepository;

    public DeleteChatMessageUseCase(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public void execute(ChatMessageId id) {
        var chatMessage = chatMessageRepository.findById(id)
                .orElseThrow(() -> new ChatMessageNotFoundApplicationException(id.value().toString()));

        chatMessage.markAsDeleted();
        chatMessageRepository.delete(chatMessage);
    }
}
