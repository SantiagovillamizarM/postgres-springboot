package com.tarea.domain.treatmentstatus.model.aggregate;

import com.tarea.domain.common.model.AggregateRoot;
import com.tarea.domain.treatmentstatus.event.TreatmentStatusDeletedEvent;
import com.tarea.domain.treatmentstatus.event.TreatmentStatusRegisteredEvent;
import com.tarea.domain.treatmentstatus.event.TreatmentStatusUpdatedEvent;
import com.tarea.domain.treatmentstatus.model.valueobject.TreatmentStatusId;

import java.time.LocalDateTime;
import java.util.Objects;

public class TreatmentStatus extends AggregateRoot {
    private final TreatmentStatusId id;
    private String code;
    private String name;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private TreatmentStatus(TreatmentStatusId id, String code, String name, boolean active,
                            LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = Objects.requireNonNull(id, "El ID no puede ser nulo");
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        this.active = active;
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación no puede ser nula");
        this.updatedAt = updatedAt;
    }

    public static TreatmentStatus register(String code, String name, Boolean active) {
        TreatmentStatusId id = TreatmentStatusId.generate();
        LocalDateTime now = LocalDateTime.now();
        boolean activeValue = active != null ? active : true;

        TreatmentStatus treatmentStatus = new TreatmentStatus(id, code, name, activeValue, now, null);
        treatmentStatus.recordEvent(new TreatmentStatusRegisteredEvent(id, now));
        return treatmentStatus;
    }

    public static TreatmentStatus restore(TreatmentStatusId id, String code, String name, boolean active,
                                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new TreatmentStatus(id, code, name, active, createdAt, updatedAt);
    }

    public void update(String code, String name, Boolean active) {
        this.code = Objects.requireNonNull(code, "El código no puede ser nulo");
        this.name = Objects.requireNonNull(name, "El nombre no puede ser nulo");
        if (active != null) {
            this.active = active;
        }
        this.updatedAt = LocalDateTime.now();

        recordEvent(new TreatmentStatusUpdatedEvent(this.id, this.code, this.name, this.updatedAt));
    }

    public void markAsDeleted() {
        recordEvent(new TreatmentStatusDeletedEvent(this.id, LocalDateTime.now()));
    }

    public TreatmentStatusId id() { return id; }
    public String code() { return code; }
    public String name() { return name; }
    public boolean active() { return active; }
    public LocalDateTime createdAt() { return createdAt; }
    public LocalDateTime updatedAt() { return updatedAt; }
}
