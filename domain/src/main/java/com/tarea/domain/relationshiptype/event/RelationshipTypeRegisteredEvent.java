package com.tarea.domain.relationshiptype.event;

import com.tarea.domain.common.event.DomainEvent;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public record RelationshipTypeRegisteredEvent(RelationshipTypeId id, LocalDateTime occurredOn) implements DomainEvent {
    public RelationshipTypeRegisteredEvent {
        Objects.requireNonNull(id, "El ID no puede ser nulo");
        Objects.requireNonNull(occurredOn, "La fecha de ocurrencia no puede ser nula");
    }
}
