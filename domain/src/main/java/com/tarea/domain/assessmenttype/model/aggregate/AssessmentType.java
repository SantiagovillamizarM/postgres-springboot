package com.tarea.domain.assessmenttype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.assessmenttype.event.AssessmentTypeDeletedEvent;
import com.tarea.domain.assessmenttype.event.AssessmentTypeRegisteredEvent;
import com.tarea.domain.assessmenttype.event.AssessmentTypeUpdatedEvent;
import com.tarea.domain.assessmenttype.model.valueobject.AssessmentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class AssessmentType extends AggregateRoot {
    private final AssessmentTypeId id;
    private String code;
    private String name;
    private boolean active;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private AssessmentType(AssessmentTypeId id, String code, String name, boolean active, String description,
                           LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        this.active = active;
        this.description = description;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static AssessmentType register(String code, String name, Boolean active, String description) {
        AssessmentTypeId id = AssessmentTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        AssessmentType assessmentType = new AssessmentType(id, code, name, activeValue, description, now, null);
        assessmentType.recordEvent(new AssessmentTypeRegisteredEvent(id, now));
        return assessmentType;
    }

    public static AssessmentType restore(AssessmentTypeId id, String code, String name, boolean active,
                                         String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new AssessmentType(id, code, name, active, description, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active, String description) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        if (active != null) {
            this.active = active;
        }
        this.description = description;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new AssessmentTypeUpdatedEvent(this.id, this.code, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new AssessmentTypeDeletedEvent(this.id, LocalDateTime.now()));
    }

    public AssessmentTypeId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public String description() { return description; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
