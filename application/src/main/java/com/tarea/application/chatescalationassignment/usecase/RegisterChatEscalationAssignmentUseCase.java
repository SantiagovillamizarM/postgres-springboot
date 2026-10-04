package com.tarea.application.chatescalationassignment.usecase;

import com.tarea.application.chatescalationassignment.command.RegisterChatEscalationAssignmentCommand;
import com.tarea.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.tarea.domain.chatescalationassignment.model.aggregate.ChatEscalationAssignment;
import com.tarea.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

public class RegisterChatEscalationAssignmentUseCase {

    private final ChatEscalationAssignmentRepository chatEscalationAssignmentRepository;

    public RegisterChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        this.chatEscalationAssignmentRepository = chatEscalationAssignmentRepository;
    }

    public ChatEscalationAssignmentResponse execute(RegisterChatEscalationAssignmentCommand command) {
        ChatEscalationAssignment chatEscalationAssignment = ChatEscalationAssignment.register(
                command.escalationId(),
                command.professionalId(),
                command.assignedAt()
        );

        ChatEscalationAssignment saved = chatEscalationAssignmentRepository.save(chatEscalationAssignment);

        return new ChatEscalationAssignmentResponse(
            saved.id().value(),
            saved.escalationId().value(),
            saved.professionalId().value(),
            saved.assignedAt()
        );
    }
}
