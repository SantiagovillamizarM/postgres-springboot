package com.tarea.domain.professionaltype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.professionaltype.event.ProfessionalTypeDeletedEvent;
import com.tarea.domain.professionaltype.event.ProfessionalTypeRegisteredEvent;
import com.tarea.domain.professionaltype.event.ProfessionalTypeUpdatedEvent;
import com.tarea.domain.professionaltype.model.valueobject.ProfessionalTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProfessionalType extends AggregateRoot {
    private final ProfessionalTypeId id;
    private String name;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ProfessionalType(ProfessionalTypeId id, String name, LocalDateTime createdAt,
                             LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ProfessionalType register(String name) {
        ProfessionalTypeId id = ProfessionalTypeId.generate();
        LocalDateTime now = LocalDateTime.now();

        ProfessionalType professionalType = new ProfessionalType(id, name, now, null);
        professionalType.recordEvent(new ProfessionalTypeRegisteredEvent(id, now));
        return professionalType;
    }

    public static ProfessionalType restore(ProfessionalTypeId id, String name, LocalDateTime createdAt,
                                           LocalDateTime updatedAt) {
        return new ProfessionalType(id, name, createdAt, updatedAt);
    }

    public void update(String name) {
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ProfessionalTypeUpdatedEvent(this.id, this.name, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ProfessionalTypeDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ProfessionalTypeId id() { return id; }
    public String name() { return name; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
