package com.tarea.application.chatmessage.usecase;

import com.tarea.application.chatmessage.dto.ChatMessageResponse;
import com.tarea.domain.chatmessage.port.repository.ChatMessageRepository;

import java.util.List;

public class ListChatMessageUseCase {

    private final ChatMessageRepository chatMessageRepository;

    public ListChatMessageUseCase(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public List<ChatMessageResponse> execute() {
        return chatMessageRepository.findAll().stream()
                .map(chatMessage -> new ChatMessageResponse(
                    chatMessage.id().value(),
                    chatMessage.conversationId().value(),
                    chatMessage.messageTypeId().value(),
                    chatMessage.participantId().value(),
                    chatMessage.content(),
                    chatMessage.metadata(),
                    chatMessage.createdAt()
                ))
                .toList();
    }
}
