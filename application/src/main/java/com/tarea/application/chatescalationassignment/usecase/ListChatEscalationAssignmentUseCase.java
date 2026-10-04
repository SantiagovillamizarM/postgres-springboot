package com.tarea.application.chatescalationassignment.usecase;

import com.tarea.application.chatescalationassignment.dto.ChatEscalationAssignmentResponse;
import com.tarea.domain.chatescalationassignment.port.repository.ChatEscalationAssignmentRepository;

import java.util.List;

public class ListChatEscalationAssignmentUseCase {

    private final ChatEscalationAssignmentRepository chatEscalationAssignmentRepository;

    public ListChatEscalationAssignmentUseCase(ChatEscalationAssignmentRepository chatEscalationAssignmentRepository) {
        this.chatEscalationAssignmentRepository = chatEscalationAssignmentRepository;
    }

    public List<ChatEscalationAssignmentResponse> execute() {
        return chatEscalationAssignmentRepository.findAll().stream()
                .map(chatEscalationAssignment -> new ChatEscalationAssignmentResponse(
                    chatEscalationAssignment.id().value(),
                    chatEscalationAssignment.escalationId().value(),
                    chatEscalationAssignment.professionalId().value(),
                    chatEscalationAssignment.assignedAt()
                ))
                .toList();
    }
}
