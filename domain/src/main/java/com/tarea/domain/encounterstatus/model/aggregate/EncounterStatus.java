package com.tarea.domain.encounterstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encounterstatus.event.EncounterStatusDeletedEvent;
import com.tarea.domain.encounterstatus.event.EncounterStatusRegisteredEvent;
import com.tarea.domain.encounterstatus.event.EncounterStatusUpdatedEvent;
import com.tarea.domain.encounterstatus.model.valueobject.EncounterStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EncounterStatus extends AggregateRoot {
    private final EncounterStatusId id;
    private String code;
    private String name;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterStatus(EncounterStatusId id, String code, String name, boolean active,
                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static EncounterStatus register(String code, String name, Boolean active) {
        EncounterStatusId id = EncounterStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        EncounterStatus encounterStatus = new EncounterStatus(id, code, name, activeValue, now, null);
        encounterStatus.recordEvent(new EncounterStatusRegisteredEvent(id, now));
        return encounterStatus;
    }

    public static EncounterStatus restore(EncounterStatusId id, String code, String name, boolean active,
                                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new EncounterStatus(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new EncounterStatusUpdatedEvent(this.id, this.code, this.name, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new EncounterStatusDeletedEvent(this.id, LocalDateTime.now()));
    }

    public EncounterStatusId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
