package com.tarea.application.chatescalationassignment.usecase;

import com.tarea.application.chatescalationassignment.command.UpdateChatEscalationAssignmentCommand;
import com.tarea.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.tarea.application.chatescalationassignment.exception.ChatEscalationAssignmentNotFoundApplicationException;
import com.tarea.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class UpdateChatEscalationAssignmentUseCase {

    private final ChatEscalationAssignmentRepository chatEscalationAssignmentRepository;

    public UpdateChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        this.chatEscalationAssignmentRepository = chatEscalationAssignmentRepository;
    }

    public ChatEscalationAssignmentResponse execute(UpdateChatEscalationAssignmentCommand command) {
        var chatEscalationAssignment = chatEscalationAssignmentRepository.findById(command.id())
                .orElseThrow(() -> new ChatEscalationAssignmentNotFoundApplicationException(command.id().value().toString()));

        chatEscalationAssignment.update(
                command.escalationId(),
                command.professionalId(),
                command.assignedAt()
        );

        var updated = chatEscalationAssignmentRepository.save(chatEscalationAssignment);

        return new ChatEscalationAssignmentResponse(
            updated.id().value(),
            updated.escalationId().value(),
            updated.professionalId().value(),
            updated.assignedAt()
        );
    }
}
