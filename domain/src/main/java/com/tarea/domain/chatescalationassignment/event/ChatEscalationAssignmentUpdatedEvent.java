package com.tarea.domain.chatescalationassignment.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.chatescalation.model.valueobject.ChatEscalationId;
import com.tarea.domain.professional.model.valueobject.ProfessionalId;
import com.tarea.domain.chatescalationassignment.model.valueobject.ChatEscalationAssignmentId;

import java.time.LocalDateTime;
import java.util.Objects;

public record ChatEscalationAssignmentUpdatedEvent(
        ChatEscalationAssignmentId id,
        ChatEscalationId escalationId,
        ProfessionalId professionalId,
        LocalDateTime occurredOn
) implements DomainEvent {
    public ChatEscalationAssignmentUpdatedEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(escalationId, "El escalamiento no puede ser nulo");
        Objects.requireNonNull(professionalId, "El profesional no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
