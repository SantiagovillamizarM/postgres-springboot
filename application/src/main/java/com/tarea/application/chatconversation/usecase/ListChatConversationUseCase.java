package com.tarea.application.chatconversation.usecase;

import com.tarea.application.chatconversation.dto.ChatConversationResponse;
import com.tarea.domain.chatconversation.port.repository.ChatConversationRepository;

import java.util.List;

public class ListChatConversationUseCase {

    private final ChatConversationRepository chatConversationRepository;

    public ListChatConversationUseCase(ChatConversationRepository chatConversationRepository) {
        this.chatConversationRepository = chatConversationRepository;
    }

    public List<ChatConversationResponse> execute() {
        return chatConversationRepository.findAll().stream()
                .map(chatConversation -> new ChatConversationResponse(
                    chatConversation.id().value(),
                    chatConversation.conversationStatusId().value(),
                    chatConversation.priorityId().value(),
                    chatConversation.lastMessageAt(),
                    chatConversation.closed(),
                    chatConversation.closedAt(),
                    chatConversation.closedBy() != null ? chatConversation.closedBy().value() : null,
                    chatConversation.createdAt(),
                    chatConversation.updatedAt()
                ))
                .toList();
    }
}
