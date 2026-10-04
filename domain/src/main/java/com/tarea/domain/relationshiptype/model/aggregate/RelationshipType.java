package com.tarea.domain.relationshiptype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.relationshiptype.event.RelationshipTypeDeletedEvent;
import com.tarea.domain.relationshiptype.event.RelationshipTypeRegisteredEvent;
import com.tarea.domain.relationshiptype.event.RelationshipTypeUpdatedEvent;
import com.tarea.domain.relationshiptype.model.valueobject.RelationshipTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class RelationshipType extends AggregateRoot {
    private final RelationshipTypeId id;
    private String description;

    private RelationshipType(RelationshipTypeId id, String description) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.description = Objects.requireNonNull(description, "La descripción no puede ser nula");
    }

    public static RelationshipType register(String description) {
        RelationshipTypeId id = RelationshipTypeId.generate();
        LocalDateTime now = LocalDateTime.now();

        RelationshipType relationshipType = new RelationshipType(id, description);
        relationshipType.recordEvent(new RelationshipTypeRegisteredEvent(id, now));
        return relationshipType;
    }

    public static RelationshipType restore(RelationshipTypeId id, String description) {
        return new RelationshipType(id, description);
    }

    public void update(String description) {
        this.description = Objects.requireNonNull(description, "La descripción no puede ser nula");

        recordEvent(new RelationshipTypeUpdatedEvent(this.id, this.description, LocalDateTime.now()));
    }

    public void markAsDeleted() {
        recordEvent(new RelationshipTypeDeletedEvent(this.id, LocalDateTime.now()));
    }

    public RelationshipTypeId id() { return id; }
    public String description() { return description; }
}
