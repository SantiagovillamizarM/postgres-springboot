package com.tarea.application.chatescalationassignment.usecase;

import com.tarea.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.tarea.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class DeleteChatEscalationAssignmentUseCase {

    private final ChatEscalationAssignmentRepository chatEscalationAssignmentRepository;

    public DeleteChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        this.chatEscalationAssignmentRepository = chatEscalationAssignmentRepository;
    }

    public void execute(ChatEscalationAssignmentId id) {
        var chatEscalationAssignment = chatEscalationAssignmentRepository.findById(id)
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(id.value().toString()));

        chatEscalationAssignment.markAsDeleted();
        chatEscalationAssignmentRepository.delete(chatEscalationAssignment);
    }
}
