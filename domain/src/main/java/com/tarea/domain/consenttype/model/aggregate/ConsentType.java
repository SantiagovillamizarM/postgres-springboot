package com.tarea.domain.consenttype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.consenttype.event.ConsentTypeDeletedEvent;
import com.tarea.domain.consenttype.event.ConsentTypeRegisteredEvent;
import com.tarea.domain.consenttype.event.ConsentTypeUpdatedEvent;
import com.tarea.domain.consenttype.model.valueobject.ConsentTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class ConsentType extends AggregateRoot {
    private final ConsentTypeId id;
    private String code;
    private String name;
    private boolean active;
    private String description;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private ConsentType(ConsentTypeId id, String code, String name, boolean active, String description,
                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        this.active = active;
        this.description = description;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static ConsentType register(String code, String name, Boolean active, String description) {
        ConsentTypeId id = ConsentTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        ConsentType consentType = new ConsentType(id, code, name, activeValue, description, now, null);
        consentType.recordEvent(new ConsentTypeRegisteredEvent(id, now));
        return consentType;
    }

    public static ConsentType restore(ConsentTypeId id, String code, String name, boolean active,
                                      String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new ConsentType(id, code, name, active, description, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active, String description) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        if (active != null) {
            this.active = active;
        }
        this.description = description;
        this.updatedAt = LocalDateTime.now();

        recordEvent(new ConsentTypeUpdatedEvent(this.id, this.code, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new ConsentTypeDeletedEvent(this.id, LocalDateTime.now()));
    }

    public ConsentTypeId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public String description() { return description; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
