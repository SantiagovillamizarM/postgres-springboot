package com.tarea.application.chatconversation.usecase;

import com.tarea.application.chatconversation.exception.ChatConversationNotFoundApplicationException;
import com.tarea.domain.chatconversation.model.valueobject.ChatConversationId;
import com.tarea.domain.chatconversation.port.repository.ChatConversationRepository;

public class DeleteChatConversationUseCase {

    private final ChatConversationRepository chatConversationRepository;

    public DeleteChatConversationUseCase(ChatConversationRepository chatConversationRepository) {
        this.chatConversationRepository = chatConversationRepository;
    }

    public void execute(ChatConversationId id) {
        var chatConversation = chatConversationRepository.findById(id)
                .orElseThrow(() -> new ChatConversationNotFoundApplicationException(id.value().toString()));

        chatConversation.markAsDeleted();
        chatConversationRepository.delete(chatConversation);
    }
}
