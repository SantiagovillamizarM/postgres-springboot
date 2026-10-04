package com.tarea.application.chatairun.usecase;

import com.tarea.application.chatairun.dto.ChatAiRunResponse;
import com.tarea.domain.chatairun.port.repository.ChatAiRunRepository;

import java.util.List;

public class ListChatAiRunUseCase {

    private final ChatAiRunRepository chatAiRunRepository;

    public ListChatAiRunUseCase(ChatAiRunRepository chatAiRunRepository) {
        this.chatAiRunRepository = chatAiRunRepository;
    }

    public List<ChatAiRunResponse> execute() {
        return chatAiRunRepository.findAll().stream()
                .map(chatAiRun -> new ChatAiRunResponse(
                    chatAiRun.id().value(),
                    chatAiRun.conversationId().value(),
                    chatAiRun.messageId().value(),
                    chatAiRun.modelId().value(),
                    chatAiRun.aiRunStatusId().value(),
                    chatAiRun.createdAt(),
                    chatAiRun.updatedAt()
                ))
                .toList();
    }
}
