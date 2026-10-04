package com.tarea.application.chatparticipant.usecase;

import com.tarea.application.chatparticipant.exception.ChatParticipantNotFoundApplicationException;
import com.tarea.domain.chatparticipant.model.valueobject.ChatParticipantId;
import com.tarea.domain.chatparticipant.port.repository.ChatParticipantRepository;

public class DeleteChatParticipantUseCase {

    private final ChatParticipantRepository chatParticipantRepository;

    public DeleteChatParticipantUseCase(ChatParticipantRepository chatParticipantRepository) {
        this.chatParticipantRepository = chatParticipantRepository;
    }

    public void execute(ChatParticipantId id) {
        var chatParticipant = chatParticipantRepository.findById(id)
                .orElseThrow(() -> new ChatParticipantNotFoundApplicationException(id.value().toString()));

        chatParticipant.markAsDeleted();
        chatParticipantRepository.delete(chatParticipant);
    }
}
