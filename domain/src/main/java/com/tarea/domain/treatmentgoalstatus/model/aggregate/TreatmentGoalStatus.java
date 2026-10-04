package com.tarea.domain.treatmentgoalstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.treatmentgoalstatus.event.TreatmentGoalStatusDeletedEvent;
import com.tarea.domain.treatmentgoalstatus.event.TreatmentGoalStatusRegisteredEvent;
import com.tarea.domain.treatmentgoalstatus.event.TreatmentGoalStatusUpdatedEvent;
import com.tarea.domain.treatmentgoalstatus.model.valueobject.TreatmentGoalStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentGoalStatus extends AggregateRoot {
    private final TreatmentGoalStatusId id;
    private String code;
    private String name;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentGoalStatus(TreatmentGoalStatusId id, String code, String name, boolean active,
                                LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static TreatmentGoalStatus register(String code, String name, Boolean active) {
        TreatmentGoalStatusId id = TreatmentGoalStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        TreatmentGoalStatus treatmentGoalStatus = new TreatmentGoalStatus(id, code, name, activeValue, now, null);
        treatmentGoalStatus.recordEvent(new TreatmentGoalStatusRegisteredEvent(id, now));
        return treatmentGoalStatus;
    }

    public static TreatmentGoalStatus restore(TreatmentGoalStatusId id, String code, String name,
                                              boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new TreatmentGoalStatus(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new TreatmentGoalStatusUpdatedEvent(this.id, this.code, this.name, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new TreatmentGoalStatusDeletedEvent(this.id, LocalDateTime.now()));
    }

    public TreatmentGoalStatusId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
