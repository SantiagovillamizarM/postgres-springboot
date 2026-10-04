package com.tarea.domain.encountertype.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encountertype.event.EncounterTypeDeletedEvent;
import com.tarea.domain.encountertype.event.EncounterTypeRegisteredEvent;
import com.tarea.domain.encountertype.event.EncounterTypeUpdatedEvent;
import com.tarea.domain.encountertype.model.valueobject.EncounterTypeId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EncounterType extends AggregateRoot {
    private final EncounterTypeId id;
    private String code;
    private String name;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterType(EncounterTypeId id, String code, String name, boolean active,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static EncounterType register(String code, String name, Boolean active) {
        EncounterTypeId id = EncounterTypeId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        EncounterType encounterType = new EncounterType(id, code, name, activeValue, now, null);
        encounterType.recordEvent(new EncounterTypeRegisteredEvent(id, now));
        return encounterType;
    }

    public static EncounterType restore(EncounterTypeId id, String code, String name, boolean active,
                                        LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new EncounterType(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new EncounterTypeUpdatedEvent(this.id, this.code, this.name, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new EncounterTypeDeletedEvent(this.id, LocalDateTime.now()));
    }

    public EncounterTypeId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
