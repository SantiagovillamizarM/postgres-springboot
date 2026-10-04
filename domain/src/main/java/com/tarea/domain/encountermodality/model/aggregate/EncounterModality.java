package com.tarea.domain.encountermodality.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.encountermodality.event.EncounterModalityDeletedEvent;
import com.tarea.domain.encountermodality.event.EncounterModalityRegisteredEvent;
import com.tarea.domain.encountermodality.event.EncounterModalityUpdatedEvent;
import com.tarea.domain.encountermodality.model.valueobject.EncounterModalityId;

import java.time.LocalDateTime;
import java.util.Objects;

public class EncounterModality extends AggregateRoot {
    private final EncounterModalityId id;
    private String code;
    private String name;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private EncounterModality(EncounterModalityId id, String code, String name, boolean active,
                              LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static EncounterModality register(String code, String name, Boolean active) {
        EncounterModalityId id = EncounterModalityId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        EncounterModality encounterModality = new EncounterModality(id, code, name, activeValue, now, null);
        encounterModality.recordEvent(new EncounterModalityRegisteredEvent(id, now));
        return encounterModality;
    }

    public static EncounterModality restore(EncounterModalityId id, String code, String name, boolean active,
                                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new EncounterModality(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = name;
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new EncounterModalityUpdatedEvent(this.id, this.code, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new EncounterModalityDeletedEvent(this.id, LocalDateTime.now()));
    }

    public EncounterModalityId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
