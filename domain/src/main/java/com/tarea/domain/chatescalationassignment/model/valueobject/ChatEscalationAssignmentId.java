package com.tarea.domain.chatescalationassignment.model.valueobject;

import java.util.Objects;
import java.util.UUID;

public record ChatEscalationAssignmentId(UUID value) {
    public ChatEscalationAssignmentId {
        Objects.requireNonNull(value, "El valor de ChatEscalationAssignmentId no puede ser nulo");
    }

    public static ChatEscalationAssignmentId generate() {
        return new ChatEscalationAssignmentId(UUID.randomUUID());
    }
}
