package com.tarea.application.chatparticipant.usecase;

import com.tarea.application.chatparticipant.dto.ChatParticipantResponse;
import com.tarea.application.chatparticipant.exception.ChatParticipantNotFoundApplicationException;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class GetChatParticipantByIdUseCase {

    private final ChatParticipantRepository chatParticipantRepository;

    public GetChatParticipantByIdUseCase(ChatParticipantRepository chatParticipantRepository) {
        this.chatParticipantRepository = chatParticipantRepository;
    }

    public ChatParticipantResponse execute(ChatParticipantId id) {
        var chatParticipant = chatParticipantRepository.findById(id)
                .orElseThrow(() -> new ChatParticipantNotFoundApplicationException(id.value().toString()));

        return new ChatParticipantResponse(
            chatParticipant.id().value(),
            chatParticipant.conversationId().value(),
            chatParticipant.participantTypeId().value(),
            chatParticipant.patientId() != null ? chatParticipant.patientId().value() : null,
            chatParticipant.professionalId() != null ? chatParticipant.professionalId().value() : null,
            chatParticipant.createdAt(),
            chatParticipant.updatedAt()
        );
    }
}
