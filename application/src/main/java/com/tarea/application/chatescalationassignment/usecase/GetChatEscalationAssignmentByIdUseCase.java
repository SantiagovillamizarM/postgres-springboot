package com.tarea.application.chatescalationassignment.usecase;

import com.tarea.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.tarea.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;
import com.tarea.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class GetChatEscalationAssignmentByIdUseCase {

    private final ChatEscalationAssignmentRepository chatEscalationAssignmentRepository;

    public GetChatEscalationAssignmentByIdUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        this.chatEscalationAssignmentRepository = chatEscalationAssignmentRepository;
    }

    public ChatEscalationAssignmentResponse execute(ChatEscalationAssignmentId id) {
        var chatEscalationAssignment = chatEscalationAssignmentRepository.findById(id)
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(id.value().toString()));

        return new ChatEscalationAssignmentResponse(
            chatEscalationAssignment.id().value(),
            chatEscalationAssignment.escalationId().value(),
            chatEscalationAssignment.professionalId().value(),
            chatEscalationAssignment.assignedAt()
        );
    }
}
