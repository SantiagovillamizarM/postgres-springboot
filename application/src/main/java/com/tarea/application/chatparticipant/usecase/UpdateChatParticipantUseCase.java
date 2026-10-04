package com.tarea.application.chatparticipant.usecase;

import com.tarea.application.chatparticipant.command.UpdateChatParticipantCommand;
import com.tarea.application.chatparticipant.dto.ChatParticipantResponse;
import com.tarea.application.chatparticipant.exception.ChatParticipantNotFoundApplicationException;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class UpdateChatParticipantUseCase {

    private final ChatParticipantRepository chatParticipantRepository;

    public UpdateChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        this.chatParticipantRepository = chatParticipantRepository;
    }

    public ChatParticipantResponse execute(UpdateChatParticipantCommand command) {
        var chatParticipant = chatParticipantRepository.findById(command.id())
                .orElseThrow(() -> new ChatParticipantNotFoundApplicationException(command.id().value().toString()));

        chatParticipant.update(
                command.conversationId(),
                command.participantTypeId(),
                command.patientId(),
                command.professionalId()
        );

        var updated = chatParticipantRepository.save(chatParticipant);

        return new ChatParticipantResponse(
            updated.id().value(),
            updated.conversationId().value(),
            updated.participantTypeId().value(),
            updated.patientId() != null ? updated.patientId().value() : null,
            updated.professionalId() != null ? updated.professionalId().value() : null,
            updated.createdAt(),
            updated.updatedAt()
        );
    }
}
