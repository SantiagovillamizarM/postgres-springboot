package com.tarea.application.chatparticipant.usecase;

import com.tarea.application.chatparticipant.dto.ChatParticipantResponse;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;

import java.util.List;

public class ListChatParticipantUseCase {

    private final ChatParticipantRepository chatParticipantRepository;

    public ListChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        this.chatParticipantRepository = chatParticipantRepository;
    }

    public List<ChatParticipantResponse> execute() {
        return chatParticipantRepository.findAll().stream()
                .map(chatParticipant -> new ChatParticipantResponse(
                    chatParticipant.id().value(),
                    chatParticipant.conversationId().value(),
                    chatParticipant.participantTypeId().value(),
                    chatParticipant.patientId() != null ? chatParticipant.patientId().value() : null,
                    chatParticipant.professionalId() != null ? chatParticipant.professionalId().value() : null,
                    chatParticipant.createdAt(),
                    chatParticipant.updatedAt()
                ))
                .toList();
    }
}
