package com.tarea.application.chatescalationassignment.command;

import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

import java.time.LocalDateTime;

public record UpdateChatEscalationAssignmentCommand(
        ChatEscalationAssignmentId id,
        ChatEscalationId escalationId,
        ProfessionalId professionalId,
        LocalDateTime assignedAt
) {
}
